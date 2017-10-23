package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask3;

import java.io.IOException;
import java.util.*;

import static com.epam.courses.jf.practice.common.second.ITestableTask3.IPoem;

/**
 * Проверяет выполнение третьей задачи.
 *
 * Занести строки, составляющие стихотворения указанного автора, в список.
 * Провести сортировку по возрастанию длин строк.
 */
public class Task3Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param poems Анализируемые стихотворения.
     * @param author Автор, стихотворения которого необходимо выбрать.
     * @param expected Отсортированные строки выбранных стихотворений.
     */
    private void test(Set<IPoem> poems, String author, List<String> expected) throws IOException {
        // Prepare
        ITestableTask3 solver = TASK_STORAGE.getSolver(ITestableTask3.class);

        // Run
        List<String> result = solver.sortPoems(poems, author);

        // Asserts
        Assert.assertEquals(expected, result);
    }

    /**
     * Стихотворения указанного автора отсуствуют.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        Set<IPoem> poems = new HashSet<>(3);
        poems.add(createPoem(Arrays.asList("1", "_2", "__3"), "A"));
        poems.add(createPoem(Arrays.asList("1", "_2", "__3"), "B"));
        poems.add(createPoem(Arrays.asList("1", "_2", "__3"), "C"));
        test(poems, "D", Collections.<String>emptyList());
    }

    /**
     * Одно стихотворение автора, сортировка не требуется.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        Set<IPoem> poems = new HashSet<>(3);
        poems.add(createPoem(Arrays.asList("1", "_2", "__3"), "A"));
        poems.add(createPoem(Arrays.asList("1", "_2", "__3"), "B"));
        poems.add(createPoem(Arrays.asList("1", "_2", "__3"), "C"));
        test(poems, "A", Arrays.asList("1", "_2", "__3"));
    }

    /**
     * Одно стихотворение автора, требуется сортировка.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        Set<IPoem> poems = new HashSet<>(3);
        poems.add(createPoem(Arrays.asList("_2", "__3", "1"), "A"));
        poems.add(createPoem(Arrays.asList("1", "_2", "__3"), "B"));
        poems.add(createPoem(Arrays.asList("1", "_2", "__3"), "C"));
        test(poems, "A", Arrays.asList("1", "_2", "__3"));
    }

    /**
     * Несколько стихотворений автора, требуется сортировка.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        Set<IPoem> poems = new HashSet<>(3);
        poems.add(createPoem(Arrays.asList("_2", "__3", "1"), "A"));
        poems.add(createPoem(Arrays.asList("___4", "1", "_2"), "A"));
        poems.add(createPoem(Arrays.asList("1", "_2", "__3"), "B"));
        poems.add(createPoem(Arrays.asList("1", "_2", "__3"), "C"));
        test(poems, "A", Arrays.asList("1", "1", "_2", "_2", "__3", "___4"));
    }

    /**
     * @param lines Строки, составляющие стихотворение.
     * @param author Автор.
     * @return Стихотворение с указанными параметрами.
     */
    private IPoem createPoem(final List<String> lines, final String author) {
        return new IPoem() {
            @Override
            public List<String> getLines() {
                return lines;
            }

            @Override
            public String getAuthor() {
                return author;
            }
        };
    }
}
