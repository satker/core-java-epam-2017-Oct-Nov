package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask4;

import java.util.HashSet;
import java.util.Set;

/**
 * Интерфейс для юнит-тестирования задания №4.
 * Определить множество на основе множества целых чисел.
 * Создать методы для определения пересечения и объединения множеств.
 */

public class Task4 implements ITestableTask4 {

    /**
     * Операция пересечения целочисленных множеств.
     *
     * @param first  Первое множество.
     * @param second Второе множество.
     * @return Результат пересечения множеств.
     */

    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersectionOfMany = new HashSet<>(first);
        intersectionOfMany.retainAll(second);
        return intersectionOfMany;
    }

    /**
     * Операция объединения целочисленных множеств.
     *
     * @param first  Первое множество.
     * @param second Второе множество.
     * @return Результат объединения множеств.
     */

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> unionOfMany = new HashSet<>(first);
        unionOfMany.addAll(second);
        return unionOfMany;
    }
}
