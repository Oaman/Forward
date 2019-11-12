package com.oman.forward.pattern.structure.adapter;

public class ServiceTwo implements PlayCount {


    @Override
    public String getServiceName() {
        return "二区";
    }

    @Override
    public int getPlayCount() {
        return Utils.getOnLinePlayCount(2);
    }
}
