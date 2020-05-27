package com.oman.forward.study.rxjava.self;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;

/**
 * @author:ZhouJiang
 * @date:2020/5/27 21:33
 * @email:zhoujiang2012@163.com
 */
class ServiceMethod {

    private final Call.Factory callFactory;
    private final String relativeUrl;
    private final boolean hasBody;
    private final ParameterHandler[] parameterHandler;
    private FormBody.Builder formBuild;
    HttpUrl baseUrl;
    String httpMethod;
    HttpUrl.Builder urlBuilder;

    public ServiceMethod(Builder builder) {
        this.callFactory = builder.mFactory;
        this.relativeUrl = builder.relativeUrl;
        this.hasBody = builder.hasBody;
        this.parameterHandler = builder.mParameterHandlers;
        this.baseUrl = builder.baseUrl;
        this.httpMethod = builder.httpMethod;
        if (hasBody) {
            formBuild = new FormBody.Builder();
        }
    }


    public Object invoke(Object[] args) {
        for (int i = 0; i < args.length; i++) {
            ParameterHandler handler = parameterHandler[i];
            handler.apply(this, args[i].toString());
        }
        HttpUrl httpUrl;
        if (urlBuilder == null) {
            urlBuilder = baseUrl.newBuilder(relativeUrl);
        }
        httpUrl = urlBuilder.build();
        FormBody body = null;
        if (formBuild != null) {
            body = formBuild.build();
        }
        Request request = new Request.Builder().url(httpUrl).method(httpMethod, body).build();
        return callFactory.newCall(request);
    }

    public void addQueryParams(String key, String value) {
        if (urlBuilder == null) {
            urlBuilder = baseUrl.newBuilder(relativeUrl);
        }
        urlBuilder.addQueryParameter(key, value);
    }

    public void addFieldParams(String key, String value) {
        formBuild.add(key, value);
    }


    static class Builder {

        Call.Factory mFactory;
        HttpUrl baseUrl;
        Annotation[] methodAnnotations;
        Annotation[][] parameterAnnotations;
        ParameterHandler[] mParameterHandlers;

        String httpMethod;
        String relativeUrl;
        boolean hasBody;

        public Builder(RetrofitSelf retrofit, Method method) {
            mFactory = retrofit.factory;
            baseUrl = retrofit.baseUrl;
            methodAnnotations = method.getAnnotations();
            parameterAnnotations = method.getParameterAnnotations();
        }

        public ServiceMethod build() {
            for (Annotation methodAnnotation : methodAnnotations) {
                if (methodAnnotation instanceof GET) {
                    this.httpMethod = "GET";
                    this.relativeUrl = ((GET) methodAnnotation).value();
                    this.hasBody = false;
                } else if (methodAnnotation instanceof POST) {
                    this.httpMethod = "POST";
                    this.relativeUrl = ((POST) methodAnnotation).value();
                    this.hasBody = true;
                }
            }
            int length = parameterAnnotations.length;
            mParameterHandlers = new ParameterHandler[length];
            for (int i = 0; i < length; i++) {
                Annotation[] annotations = parameterAnnotations[i];
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Query) {
                        String key = ((Query) annotation).value();
                        mParameterHandlers[i] = new ParameterHandler.QueryParameterHandler(key);
                    } else if (annotation instanceof Field) {
                        String key = ((Field) annotation).value();
                        mParameterHandlers[i] = new ParameterHandler.FieldParameterHandler(key);
                    }
                }
            }

            return new ServiceMethod(this);
        }
    }
}
