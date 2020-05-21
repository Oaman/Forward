package com.oman.lib.generic.type.gson;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oman.lib.generic.type.TypeRefrence;

import java.lang.reflect.Type;

public class Deserialize {

    static class Response<T> {
        T data;
        int code;
        String message;

        @Override
        public String toString() {
            return "Response{" +
                    "data=" + data +
                    ", code=" + code +
                    ", message='" + message + '\'' +
                    '}';
        }

        public Response(T data, int code, String message) {

            this.data = data;
            this.code = code;
            this.message = message;
        }
    }

    static class Data {
        String result;

        public Data(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "result=" + result +
                    '}';
        }
    }

    static class ChildTypeRefrence{
        Response<Data>  t;
    }

    public static void main(String[] args) {
        Response<Data> dataResponse = new Response(new Data("数据"), 1, "成功");

        Gson gson = new Gson();
        String json = gson.toJson(dataResponse);
        System.out.println(json);

        //反序列化......

        /**
         *  有花括号： 代表是匿名内部类，创建一个匿名内部类的实例对象
         *  没花括号：创建实例对象
         */
        Type type1 = new TypeToken<Response<Data>>(){}.getType();
        Type type = new TypeToken<Response<Data>>(){

        }.getType();

        System.out.println(type);
        Response<Data> response = gson.fromJson(json, type);
        System.out.println(response);
        System.out.println(response.data);
        System.out.println(response.data.getClass());
    }

}
