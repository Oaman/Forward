package com.oman.forward.pattern.create.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 23:03
 * @email:zhoujiang2012@163.com
 */
public class Product {
    /**
     * Prodect,产品就是我们要创建的复杂对象，一般来说包含多个部分
     */
    private List<String> parts = new ArrayList<>();

    public void add(String partName) {
        parts.add(partName);
    }

    public void show() {
        System.out.println("----产品创建----");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}