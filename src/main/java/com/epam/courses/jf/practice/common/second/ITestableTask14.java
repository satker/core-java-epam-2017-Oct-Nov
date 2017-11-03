package com.epam.courses.jf.practice.common.second;

import java.util.Collection;

/**
 * Интерфейс для юнит-тестирования задания №14.
 *
 * На базе коллекций реализовать структуру хранения чисел с поддержкой следующих операций:
 *       1) Добавление/удаление числа.
 *       2) Поиск числа, наиболее близкого к заданному (т.е. модуль разницы минимален).
 */
public interface ITestableTask14 extends ITaskStorage.ITestableTask {

    /**
     * @param required Тип, которым типизируется создаваемая коллекция.
     * @return Коллекция для хранения чисел с поддержкой операций добавления/удаления и поиска числа.
     */
    <T extends Number> INumberCollection<T> createCollection(Class<T> required);

    /**
     * Коллекция для хранения чисел.
     */
    interface INumberCollection<T extends Number> extends Collection<T> {

        /**
         * @param value Эталонное значение.
         * @return Число, наиболее близкое к заданному.
         */
        T nearest(T value);
    }
}