package com.oman.forward.pattern.structure.adapter;

public class ServiceOne implements PlayCount {

    @Override
    public String getServiceName() {
        return "一区";
    }

    @Override
    public int getPlayCount() {
        return ServiceFirst.getOnLinePlayCount();
//        return Utils.getOnLinePlayCount(1);
    }
}
