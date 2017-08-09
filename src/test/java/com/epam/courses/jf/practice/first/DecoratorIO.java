package com.epam.courses.jf.practice.first;

import org.junit.Assert;

import java.io.*;

/**
 * Содержит два потока in/out, связанные между собой.
 * Кроме того имеются два потока writeIn/readOut для записи/чтения данных из потоков in/out соответственно.
 */
public class DecoratorIO implements Closeable {

    /** Выходной поток */
    final PrintStream out;

    /** Входной поток, позволяющий читать из потока {@link DecoratorIO#out} */
    final InputStream readOut;

    /** Входной поток */
    final InputStream in;

    /** Выходной поток, позволяющий писать в поток {@link DecoratorIO#in} */
    final OutputStream writeIn;

    public DecoratorIO() {
        try {
            PipedInputStream pipedInputOut = new PipedInputStream(200000);
            readOut = pipedInputOut;
            out = new PrintStream(new PipedOutputStream(pipedInputOut));

            PipedOutputStream pipedOutputIn = new PipedOutputStream();
            writeIn = pipedOutputIn;
            in = new PipedInputStream(pipedOutputIn) {

                @Override
                public int read(byte[] b) throws IOException {
                    if (available() == 0) {
                        Assert.fail("Input stream does not contain expected data!");
                    }
                    return super.read(b);
                }

                @Override
                public synchronized int read(byte[] b, int off, int len) throws IOException {
                    if (available() == 0) {
                        Assert.fail("Input stream does not contain expected data!");
                    }
                    return super.read(b, off, len);
                }

                @Override
                public synchronized int read() throws IOException {
                    if (available() == 0) {
                        Assert.fail("Input stream does not contain expected data!");
                    }
                    return super.read();
                }
            };
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        readOut.close();
        writeIn.close();
    }
}
