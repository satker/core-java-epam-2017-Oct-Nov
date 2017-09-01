package com.epam.courses.jf.se7.singleton;

public class StaticSingleton {

    private StaticSingleton() {

    }

    public static StaticSingleton getInstance() {
        return HolderStaticSingleton.INSTANCE;
    }

    public static void method() {
        //...
    }

    private static class HolderStaticSingleton {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }
}
