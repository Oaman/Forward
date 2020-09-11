package com.oman.token;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public enum TokenSets {
    INSTANCE;
    public Set<String> tokenUrls = new CopyOnWriteArraySet<>();

    public void add(String url) {
        tokenUrls.add(url);
    }

    public boolean contains(String url) {
        return tokenUrls.contains(url);
    }
}
