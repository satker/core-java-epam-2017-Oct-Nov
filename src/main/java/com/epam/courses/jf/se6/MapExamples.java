package com.epam.courses.jf.se6;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public class MapExamples {

    public static void main(String[] args) {
        Map<C, String> map = new IdentityHashMap<>();
        map.put(new C(1), "1");
        C key = new C(2);
        map.put(key, "2");
        map.put(null, "null");
        System.out.println(map.get(key));
    }
}

class C {

    private final int value;

    C(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "C{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C c = (C) o;
        return value == c.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
