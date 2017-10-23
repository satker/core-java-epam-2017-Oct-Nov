package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask8;

import java.io.IOException;

/**
 * Проверяет выполнение восьмой задачи.
 *
 * Задана строка, возможно содержащая символы '(', ')', '[', ']', '{', '}'.
 * Проверить правильность расстановки скобок.
 * При реализации использовать стек.
 */
public class Task8Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param line Анализируемая строка.
     * @param expected Ожидаемый результат.
     */
    private void test(String line, boolean expected) throws IOException {
        // Prepare
        ITestableTask8 solver = TASK_STORAGE.getSolver(ITestableTask8.class);

        // Run
        boolean result = solver.isNormalBrackets(line);

        // Asserts
        Assert.assertEquals(expected, result);
    }

    /**
     * Строка нулевой длины.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        test("", true);
    }

    /**
     * Не содержащит скобок.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        test("abc", true);
    }

    /**
     * Правильную последовательность скобок без вложений.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        test("{}()[]", true);
    }

    /**
     * Правильная последовательность скобок со вложениями.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        test("[{()}([])[]]", true);
    }

    /**
     * Не закрытая последняя скобка.
     */
    @org.junit.Test (timeout = 2000)
    public void test5() throws Exception {
        test("[qwqe](", false);
    }

    /**
     * Не закрытая первая скобка.
     */
    @org.junit.Test (timeout = 2000)
    public void test6() throws Exception {
        test("[qweqw[qwe(qwe)]", false);
    }

    /**
     * Не парные скобки.
     */
    @org.junit.Test (timeout = 2000)
    public void test7() throws Exception {
        test("[()}", false);
    }

    /**
     * Лишняя закрывающая скобка.
     */
    @org.junit.Test (timeout = 2000)
    public void test8() throws Exception {
        test("[()]}", false);
    }
}
