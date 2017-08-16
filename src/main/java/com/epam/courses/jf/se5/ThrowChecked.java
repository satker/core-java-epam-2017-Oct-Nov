package com.epam.courses.jf.se5;

import java.io.IOException;

public class ThrowChecked {

    public static void main(String[] args) {
        Thread.currentThread().setName("Main");
        Thread.setDefaultUncaughtExceptionHandler(
                (thread, ex) -> {
                    System.out.println(thread.getName() + " unhandled " + ex);
                    throw new RuntimeException(ex);
                });
        doThrow(new IOException("IO"));
    }

    private static void doThrow(Exception e) {
        e.fillInStackTrace();
        ThrowChecked.throwChecked(e);
    }

    @SuppressWarnings({"unchecked"})
    private static <E extends Exception> void throwChecked(Exception e) throws E {
        throw (E) e;
    }
}
