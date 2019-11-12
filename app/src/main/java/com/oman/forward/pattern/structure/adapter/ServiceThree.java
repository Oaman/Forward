package com.oman.forward.pattern.structure.adapter;

public class ServiceThree implements PlayCount {


    @Override
    public String getServiceName() {
        return "三区";
    }

    @Override
    public int getPlayCount() {
        return Utils.getOnLinePlayCount(3);
    }
}
