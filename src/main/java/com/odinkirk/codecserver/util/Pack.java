package com.odinkirk.codecserver.util;

import java.util.ArrayList;
import java.util.List;

public final class Pack<T> {

    private final ArrayList<T> things;

    Pack() {
        things = new ArrayList<>();
    }

    void add(final T something) {
        things.add(something);
    }

    public ArrayList<T> getThings() {
        return things;
    }

    public boolean isEmpty() {
        return things.isEmpty();
    }

    public void removeEverything() {
        things.clear();
    }

    public static <T> Pack<T> of() {
        return new Pack<T>();
    }

    public static <T> Pack<T> of(List<T> list) {
        Pack<T> pack = new Pack<T>();
        pack.things.addAll(list);
        return pack;
    }
}




