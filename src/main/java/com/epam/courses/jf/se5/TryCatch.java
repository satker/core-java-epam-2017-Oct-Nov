package com.epam.courses.jf.se5;

import java.io.IOException;

/**
 * Created by Nikolai_Plokhoi on 8/14/2017.
 */
public class TryCatch {

    public static void main(String[] args) {
        args = null;
        try {
            checkedException();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            ex = new IllegalArgumentException();
            throw ex;
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        } finally {
            uncheckedException();
        }
    }

    private static void checkedException() throws IOException {
        throw new IOException();
    }

    private static void uncheckedException() {
        throw new RuntimeException();
    }
}
