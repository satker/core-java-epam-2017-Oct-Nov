package com.epam.courses.jf.practice.first;

import java.io.*;
import java.nio.CharBuffer;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.first.ISolver;

/**
 * Базовый класс для классов юнит-тестирования задач, входящих в первое задание.
 * Производит замену потоков ввода/вывода с консоли на замкнутые двунаправленные потоки.
 */
public abstract class AbstractTaskTest {

    /** Реализация первого задания. */
    protected final ISolver SOLVER;

    /** Входной поток для получения исходных данных. */
    private InputStream in;

    /** Выходной поток для записи исходных данных в поток {@link AbstractTaskTest#in}. */
    protected OutputStream writeIn;

    /** Выходной поток для записи результатов. */
    private PrintStream out;

    /** Входной поток для чтения результатов из потока {@link AbstractTaskTest#out}. */
    protected BufferedReader readOut;

    protected AbstractTaskTest() {
        SOLVER = SolverFactory.getInstance();
    }

    /**
     * Настраивает потоки ввода/вывода.
     * @param decoratorIO Декоратор, использующийся для данной задачи.
     */
    protected void setupStreams(DecoratorIO decoratorIO) {
        in = decoratorIO.in;
        out = decoratorIO.out;
        writeIn = decoratorIO.writeIn;
        readOut = new BufferedReader(new InputStreamReader(decoratorIO.readOut)) {

            private final StringBuilder BUILDER = new StringBuilder(100);

            @Override
            public int read() throws IOException {
                if (!ready()) {
                    Assert.fail("Output stream does not contain expected data!");
                }
                return super.read();
            }

            @Override
            public int read(char[] buffer) throws IOException {
                if (!ready()) {
                    Assert.fail("Output stream does not contain expected data!");
                }
                return super.read(buffer);
            }

            @Override
            public int read(CharBuffer target) throws IOException {
                if (!ready()) {
                    Assert.fail("Output stream does not contain expected data!");
                }
                return super.read(target);
            }

            @Override
            public String readLine() throws IOException {
                if (!ready()) {
                    Assert.fail("Output stream does not contain expected data!");
                }

                BUILDER.setLength(0);
                char current;
                while (ready()) {
                    current = (char)read();
                    if (current == '\n') {
                        if (BUILDER.charAt(BUILDER.length() - 1) == '\r') {
                            BUILDER.setLength(BUILDER.length() - 1);
                        }
                        return BUILDER.toString();
                    }
                    BUILDER.append(current);
                }
                Assert.fail("Output stream does not contain expected data!");
                return null;
            }
        };

        System.setIn(in);
        System.setOut(out);
    }

    /**
     * Производит сравнение двух объектов.
     * Обертка над стандартным методом для сокрытия в стэк-трейсе сравниваемых значений.
     * @param object1 Первый сравниваемый объект.
     * @param object2 Второй сравниваемый объект.
     */
    public void assertEquals(Object object1, Object object2) {
        assertEquals(null, object1, object2);
    }

    /**
     * Производит сравнение двух объектов.
     * Обертка над стандартным методом для сокрытия в стэк-трейсе сравниваемых значений.
     * @param message Выводимое в стэк-трейсе сообщение.
     * @param object1 Первый сравниваемый объект.
     * @param object2 Второй сравниваемый объект.
     */
    public void assertEquals(String message, Object object1, Object object2) {
        if (!object1.equals(object2)) {
            Assert.fail(message);
        }
    }

    /**
     * Проверяет истинность выражения.
     * @param expression Проверяемое выражение.
     */
    void assertTrue(boolean expression) {
        if (!expression) {
            Assert.fail("Incorrect result");
        }
    }
}
