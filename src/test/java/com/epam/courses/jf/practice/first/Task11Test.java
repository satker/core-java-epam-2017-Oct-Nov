package com.epam.courses.jf.practice.first;

import java.io.IOException;

/**
 * Проверяет выполнение одиннадцатой задачи.
 *
 * Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
 * При реализации использовать оператор switch. Осуществить проверку корректности ввода числа.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.11">Задание №11</a>}
 */
public class Task11Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param number Передаваемое в метод значение.
     * @param monthName Ожидаемое название месяца (либо "INCORRECT INPUT DATA", если передано не число).
     */
    private void test(String number, String monthName) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(number.concat("\n").getBytes());

            // Run
            SOLVER.task11();

            // Asserts
            super.assertTrue(monthName.equalsIgnoreCase(readOut.readLine()));
        }
    }

    /**
     * Получение существующего месяца.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test("2", "February");
    }

    /**
     * Получение по номеру, большему 12.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test("13", "INCORRECT INPUT DATA");
    }

    /**
     * Проверка значения, лежащего за пределами int.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test("11111111111111111111111111111111111111111", "INCORRECT INPUT DATA");
    }

    /**
     * Проверка обработки не числовых значений.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test("abc", "INCORRECT INPUT DATA");
    }
}