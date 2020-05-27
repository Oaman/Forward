package com.oman.forward.study.rxjava.self;

/**
 * @author:ZhouJiang
 * @date:2020/5/27 21:36
 * @email:zhoujiang2012@163.com
 */
public abstract class ParameterHandler {
    abstract void apply(ServiceMethod method, String value);

    static class QueryParameterHandler extends ParameterHandler{
        String key;

        public QueryParameterHandler(String key) {
            this.key = key;
        }

        @Override
        void apply(ServiceMethod method, String value) {
                method.addQueryParams(key,value);
        }
    }

    static class FieldParameterHandler extends ParameterHandler{
        String key;

        public FieldParameterHandler(String key) {
            this.key = key;
        }

        @Override
        void apply(ServiceMethod method, String value) {
            method.addFieldParams(key,value);
        }
    }
}



