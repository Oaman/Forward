package com.oman.lib.generic.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author:ZhouJiang
 * @date:2020/5/18 22:00
 * @email:zhoujiang2012@163.com
 */
public class MyTypeToken<T> {
    Type mType;

    protected MyTypeToken() {
        //Deserialize$2 extends MyTypeToken<Response<Data>>
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        //Response<Data>
        mType = parameterizedType.getActualTypeArguments()[0];
    }

    public Type getType(){
        return mType;
    }

}
