package com.oman.forward.study.rxjava.self;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/**
 * @author:ZhouJiang
 * @date:2020/5/27 21:24
 * @email:zhoujiang2012@163.com
 */
public class RetrofitSelf {
    final Map<Method, ServiceMethod> serviceMethodCache = new ConcurrentHashMap<>();

    public Call.Factory factory;
    public HttpUrl baseUrl;

    public RetrofitSelf(Builder builder) {
        factory = builder.factory;
        baseUrl = builder.httpUrl;
    }

    public <T> T create(Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                ServiceMethod serviceMethod = loadServiceMethod(method);
                return serviceMethod.invoke(args);
            }
        });
    }

    private ServiceMethod loadServiceMethod(Method method) {
        //先不上锁，避免synchronized的性能损失
        ServiceMethod result = serviceMethodCache.get(method);
        if (result != null) return result;
        //多线程下，避免重复解析,
        synchronized (serviceMethodCache) {
            result = serviceMethodCache.get(method);
            if (result == null) {
                result = new ServiceMethod.Builder(this, method).build();
                serviceMethodCache.put(method, result);
            }
        }
        return result;
    }


    public static class Builder {
        private Call.Factory factory;
        private HttpUrl httpUrl;

        public Builder factory(Call.Factory factory) {
            this.factory = factory;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            if (httpUrl == null) {
                httpUrl = HttpUrl.get(baseUrl);
            }
            return this;
        }

        public RetrofitSelf build() {
            if (httpUrl ==null){
                throw new IllegalArgumentException("base url should not empty");
            }
            if (factory == null) {
                factory = new OkHttpClient();
            }
            return new RetrofitSelf(this);
        }
    }

}
