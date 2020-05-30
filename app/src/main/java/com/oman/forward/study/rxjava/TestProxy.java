package com.oman.forward.study.rxjava;

import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Headers;
import okhttp3.MediaType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author:ZhouJiang
 * @date:2020/4/14 15:41
 * @email:zhoujiang2012@163.com
 */
public class TestProxy {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) throws NoSuchMethodException {
        IProduct mask = new FacialMask();

        Object o = (IProduct) Proxy.newProxyInstance(FacialMask.class.getClassLoader(), new Class[]{IProduct.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println(proxy);//这里相当于又调用了proxy.toString()方法，又会调用invoke
                for (Object o : args) {
                    System.out.println("param:" + o);
                }
                method.invoke(mask, args);
                System.out.println(method);
                System.out.println(mask);
                System.out.println("now 300");
                return null;
            }
        });

        IProduct product = (IProduct) o;
        product.price("hello");
        product.print("print");
        System.out.println("----------------");
        Method method = TestInterface.class.getDeclaredMethod("getData", String.class, String.class);
        System.out.println("methodAnnotation:" + method.getAnnotation(GET.class).value());
        Type[] genericParameterTypes = method.getParameterTypes();
        System.out.println("parameterType:" + genericParameterTypes[0].toString());
        Type genericReturnType = method.getGenericReturnType();
        System.out.println("returnType:" + genericReturnType.toString());
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (Annotation[] a : parameterAnnotations) {
            for (Annotation b : a) {
                System.out.println("paraAnnotation:" + b.toString());
            }
        }
        System.out.println(parameterAnnotations.toString());
        System.out.println("----------------");
        Annotation[] annotations = method.getAnnotations();
        for (Annotation a : annotations) {
            if (a instanceof GET) {
                parseHttpMethodAndPath("GET", ((GET) a).value(), false);
            } else if (a instanceof retrofit2.http.Headers) {
                parseHeaders(method, ((retrofit2.http.Headers) a).value());
            }
        }
    }

    private static void parseHttpMethodAndPath(String httpMethod, String value, boolean hasBody) {
        if (value.isEmpty()) {
            return;
        }
        System.out.println("relativeUrl:" + value);
        System.out.println(parsePathParameters(value).toString());
    }

    private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
    private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{(" + PARAM + ")\\}");

    private static Set<String> parsePathParameters(String path) {
        Matcher m = PARAM_URL_REGEX.matcher(path);
        Set<String> patterns = new LinkedHashSet<>();
        while (m.find()) {
            patterns.add(m.group(1));
        }
        return patterns;
    }

    private static Headers parseHeaders(Method method, String[] headers) {
        Headers.Builder builder = new Headers.Builder();
        for (String header : headers) {
            int colon = header.indexOf(':');
            if (colon == -1 || colon == 0 || colon == header.length() - 1) {
                throw methodError(method,
                        "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", header);
            }
            String headerName = header.substring(0, colon);
            String headerValue = header.substring(colon + 1).trim();
            if ("Content-Type".equalsIgnoreCase(headerName)) {
                try {
                    MediaType mediaType = MediaType.get(headerValue);
                    System.out.println("mediaType:" + mediaType);
                } catch (IllegalArgumentException e) {
                    throw methodError(method, e, "Malformed content type: %s", headerValue);
                }
            } else {
                builder.add(headerName, headerValue);
            }
        }
        System.out.println(builder.build().toString());
        return builder.build();
    }

    static RuntimeException methodError(Method method, String message, Object... args) {
        return methodError(method, null, message, args);
    }

    static RuntimeException methodError(Method method, @Nullable Throwable cause, String message,
                                        Object... args) {
        message = String.format(message, args);
        return new IllegalArgumentException(message
                + "\n    for method "
                + method.getDeclaringClass().getSimpleName()
                + "."
                + method.getName(), cause);
    }
}

interface TestInterface {
    @GET("home/homead/{login}/{name}")
    @retrofit2.http.Headers({"Cache-Control: max-age=640000", "name:beijing", "content-type:application/json"})
    Call<Object> getData(@Query(value = "cityId") String cityId, @Query(value = "age") String age);
}


interface IProduct {
    void price(String name);

    void print(String param);
}

class FacialMask implements IProduct {

    @Override
    public void price(String name) {
        System.out.println("出厂价格100块:" + name);
    }

    @Override
    public void print(String param) {
        System.out.println("print:" + param);
    }

}


