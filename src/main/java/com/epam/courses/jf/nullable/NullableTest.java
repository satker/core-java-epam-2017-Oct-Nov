package com.epam.courses.jf.nullable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NullableTest {

    @Nullable
    private static String field;

    @NotNull
    private static String method() {
        return "123";
    }

    private static void print(@NotNull String message) {
        System.out.println(message);
    }

    public static void main(@NotNull String[] args) {
        field = method();
        print(null);
    }

    @Nullable
    public Object nullableMethod(@NotNull String val) {
        return null;
    }

    @NotNull
    public Object notNullMethod(@Nullable String val) {
        return "123";
    }
}

class Child extends NullableTest {

    @NotNull
    @Override
    public Object nullableMethod(@Nullable String val) {
        return val == null ? "213" : val;
    }

    @NotNull
    @Override
    public Object notNullMethod(@Nullable String val) {
        return "213";
    }
}
