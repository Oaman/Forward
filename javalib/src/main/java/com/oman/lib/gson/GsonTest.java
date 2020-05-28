package com.oman.lib.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class GsonTest {

    static class GsonBean {
        private String name;
        private List<String> data;

        public GsonBean() {
        }

        public GsonBean(String name, List<String> data) {
            this.name = name;
            this.data = data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "GsonBean{" +
                    "name='" + name + '\'' +
                    ", data=" + data +
                    '}';
        }
    }

    public static void main(String... args) {
        test1();
        System.out.println("----------------------------");
        try {
            test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------");
        test3();
        System.out.println("----------------------------");
        test4();
        System.out.println("----------------------------");
        test5();
        System.out.println("----------------------------");
        test6();
    }

    private static void test1() {
        GsonBean bean = new GsonBean();
        bean.setName("Beijing");
        bean.setData(Arrays.asList("东区", "西区"));
        Gson gson = new Gson();
        String s = gson.toJson(bean);
        System.out.println(s);
    }

    private static void test2() {
        //Parse error
        String s = "{" +
                "\"name\":\"tianjin\",\n" +
                "\"data\":\"\"\n" +
                "}";
        Gson gson = new Gson();
        GsonBean bean = gson.fromJson(s, GsonBean.class);
        System.out.println(bean);
    }

    private static void test3() {
        String s = "{\n" +
                "  \"name\" : \"tianjin\", \n" +
                "  \"data\" : \"\"\n" +
                "}";
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(GsonBean.class, new JsonDeserializer<GsonBean>() {
            @Override
            public GsonBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                JsonObject jsonObj = json.getAsJsonObject();
                String name = jsonObj.get("name").getAsString();
                JsonElement data = jsonObj.get("data");

                GsonBean bean = new GsonBean();
                if (data.isJsonArray()) {
                    String[] strings = context.deserialize(data, String[].class);
                    bean.setData(Arrays.asList(strings));
                } else {
                    bean.setData(null);
                }
                bean.setName(name + "aa");
                return bean;
            }
        });
        Gson gson = builder.create();
        GsonBean bean = gson.fromJson(s, GsonBean.class);
        System.out.println(bean);
    }

    private static void test4() {
        //自定义TypeAdapter 因为默认的使用反射耗费性能
        GsonBean gsonBean = new GsonBean();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()//特殊样式打印
                .registerTypeAdapter(GsonBean.class, new TypeAdapter<GsonBean>() {
                    @Override
                    public void write(JsonWriter out, GsonBean value) throws IOException {
                        if (value == null) {
                            out.nullValue();
                            return;
                        }
                        out.beginObject();
                        out.name("name1").value(value.getName() + "Append");
                        out.name("data").value(value.getData().toString());
                        out.endObject();
                    }

                    @Override
                    public GsonBean read(JsonReader in) throws IOException {
                        if (in.peek() == JsonToken.NULL) {
                            in.nextNull();
                            return null;
                        }
                        GsonBean bean = new GsonBean();
                        in.beginObject();
                        while (in.hasNext()) {
                            //只在乎值，属性名称肯定是和类一致的，可以和test6对比
                            switch (in.nextName()) {
                                case "name1":
                                    bean.setName(in.nextString());
                                    break;
                                case "data":
                                    String s = in.nextString();
                                    bean.setData(Arrays.asList(s.substring(1, s.length() - 1).split(",")));
                                    break;
                            }
                        }
                        in.endObject();
                        return bean;
                    }
                }.nullSafe())
                .create();
        gsonBean.setName("HeNan");
        gsonBean.setData(Arrays.asList("ZhengZhou", "XuChang"));
        String json = gson.toJson(gsonBean);
        System.out.println(json);

        GsonBean bean = gson.fromJson(json, GsonBean.class);
        System.out.println(bean);
    }

    private static void test5() {
        User user = new User("one", "two", "three");
        Gson gson = new Gson();
        String s = gson.toJson(user);
        System.out.println(s);
    }

    static class User {
        @SerializedName("name")
        String a;
        @SerializedName(value = "name1")
        String b;
        String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    private static void test6() {
        User6 user = new User6("name", "age");
        Gson gson = new Gson();
        String s = gson.toJson(user);
        System.out.println(s);
        User6 user6 = gson.fromJson(s, User6.class);
        System.out.println(user6);
    }

    @JsonAdapter(value = User6TypeAdapter.class)
    static class User6 {
        String name;
        String age;

        public User6(String name, String age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User6{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }

    static class User6TypeAdapter extends TypeAdapter<User6> {

        @Override
        public void write(JsonWriter out, User6 value) throws IOException {
            out.beginObject();
            out.name("name").value(value.name + " " + value.age);
            out.endObject();
        }

        @Override
        public User6 read(JsonReader in) throws IOException {
            in.beginObject();
            in.nextName();
            String[] s = in.nextString().split(" ");
            in.endObject();
            return new User6(s[0], s[1]);
        }
    }
}
