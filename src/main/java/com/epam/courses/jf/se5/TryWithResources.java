package com.epam.courses.jf.se5;

import java.io.*;
import java.util.Arrays;

public class TryWithResources {

    public static void main(String[] args) throws IOException {
//        oldStyleResources();
        tryWithResources();
    }

    private static void oldStyleResources() throws IOException {
        InputStream input = null;
        OutputStream output = null;
        IOException fromInput = null;
        try {
            input = new ThrowableInputStream();
            output = new FileOutputStream("123.txt");
            input.read();
        } catch (IOException ex) {
            fromInput = ex;
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                if (fromInput != null) {
                    ex.initCause(fromInput);
                }
                throw ex;
            }
            if (output != null) {
                output.close();
            }
        }
    }

    /**
     *
     * @throws IOException
     */
    private static void tryWithResources() throws IOException {
        try (InputStream input = new ThrowableInputStream();
             OutputStream output = new FileOutputStream("123.txt")) {
            input.read();
        } catch (IOException ex) {
            System.out.println(Arrays.toString(ex.getSuppressed()));
        }
    }
}

class ThrowableInputStream extends InputStream {

    @Override
    public int read() throws IOException {
        throw new IOException("IOException from method read()");
    }

    @Override
    public void close() throws IOException {
        throw new IOException("IOException from method close()");
    }
}
