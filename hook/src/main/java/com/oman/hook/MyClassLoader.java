package com.oman.hook;


import dalvik.system.PathClassLoader;

public class MyClassLoader extends PathClassLoader {
    public MyClassLoader(String dexPath, String librarySearchPath, ClassLoader parent) {
        super(dexPath, librarySearchPath, parent);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }
}
