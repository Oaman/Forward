package com.oman.base;

import java.util.ServiceLoader;

public final class MyServiceLoader {
    private MyServiceLoader() {
    }

    public static <S> S load(Class<S> service) {
        try {
            return ServiceLoader.load(service).iterator().next();
        } catch (Exception e) {
            return null;
        }
    }
}
