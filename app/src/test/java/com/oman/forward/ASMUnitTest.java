package com.oman.forward;

import org.junit.Test;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.commons.Method;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ASMUnitTest {

    @Test
    public void test() {
        try {
            FileInputStream fis = new FileInputStream("D:\\develop\\androidstudio\\Forward\\app\\src\\main\\java\\com\\oman\\forward\\study\\byteinsert\\ByteInsert.class");
            ClassReader classReader = new ClassReader(fis);

            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

            //开始插桩
            classReader.accept(new MyClassVisitor(Opcodes.ASM7, classWriter), ClassReader.EXPAND_FRAMES);
            byte[] bytes = classWriter.toByteArray();
            FileOutputStream fos = new FileOutputStream("D:\\develop\\androidstudio\\Forward\\app\\src\\main\\java\\com\\oman\\forward\\study\\byteinsert\\NewByteInsert.class");
            fos.write(bytes);
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用来访问类的
     */
    static class MyClassVisitor extends ClassVisitor {

        public MyClassVisitor(int api) {
            super(api);
        }

        public MyClassVisitor(int api, ClassVisitor classVisitor) {
            super(api, classVisitor);
        }

        /**
         * 每找到一个方法，这个API就执行一次(包括构造方法)
         */
        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
            System.out.println("visitMethod name:" + name + "-descriptor:" + descriptor + "--signature:" + signature);
            return new MyMethodVisitor(api, methodVisitor, access, name, descriptor);
        }
    }

    /**
     * 用来访问方法的
     */
    static class MyMethodVisitor extends AdviceAdapter {

        /**
         * Constructs a new {@link AdviceAdapter}.
         *
         * @param api           the ASM API version implemented by this visitor. Must be one of {@link
         *                      Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
         * @param methodVisitor the method visitor to which this adapter delegates calls.
         * @param access        the method's access flags (see {@link Opcodes}).
         * @param name          the method's name.
         * @param descriptor    the method's descriptor (see {@link Type Type}).
         */
        protected MyMethodVisitor(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
            super(api, methodVisitor, access, name, descriptor);
        }

        int start;

        @Override
        protected void onMethodEnter() {
            super.onMethodEnter();
            if (!injected) {
                return;
            }
//            INVOKESTATIC java/lang/System.currentTimeMillis ()J
//            LSTORE 1
            invokeStatic(Type.getType("Ljava/lang/System;"), new Method("currentTimeMillis", "()J"));
            start = newLocal(Type.LONG_TYPE);
            storeLocal(start);
        }

        int end;

        @Override
        protected void onMethodExit(int opcode) {
            super.onMethodExit(opcode);
            if (!injected) {
                return;
            }
//            INVOKESTATIC java/lang/System.currentTimeMillis ()J
//            LSTORE 3
            invokeStatic(Type.getType("Ljava/lang/System;"), new Method("currentTimeMillis", "()J"));
            end = newLocal(Type.LONG_TYPE);
            storeLocal(end);
//            GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
            getStatic(Type.getType("Ljava/lang/System;"), "out", Type.getType("Ljava/io/PrintStream;"));
//            NEW java/lang/StringBuilder
            newInstance(Type.getType("Ljava/lang/StringBuilder;"));
//            DUP
            dup();
//            INVOKESPECIAL java/lang/StringBuilder.<init> ()V
            invokeConstructor(Type.getType("Ljava/lang/StringBuilder;"), new Method("<init>", "()V"));
//            LDC "execute time:"
            visitLdcInsn("execute time:");
//            INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;"));
//            LLOAD 3
            loadLocal(end);
//            LLOAD 1
            loadLocal(start);
//            LSUB
            math(SUB, Type.LONG_TYPE);
//            INVOKEVIRTUAL java/lang/StringBuilder.append (J)Ljava/lang/StringBuilder;
            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("append", "(J)Ljava/lang/StringBuilder;"));
//            LDC "ms"
            visitLdcInsn("ms");
//            INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
//            INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
//            INVOKEVIRTUAL java/io/ PrintStream.println (Ljava/lang/String;)V
            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;"));
            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("toString", "()Ljava/lang/String;"));
            invokeVirtual(Type.getType("Ljava/io/PrintStream;"), new Method("println", "(Ljava/lang/String;)V;"));
        }

        boolean injected = false;

        @Override
        public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
            System.out.println(getName() + "--visitAnnotation-->" + descriptor);
            if ("Ljava/lang/Deprecated;".equals(descriptor)) {
                injected = true;
            }
            return super.visitAnnotation(descriptor, visible);
        }
    }

}
