package com.epam.courses.jf.practice.common.second;

import java.io.File;
import java.util.HashMap;

/**
 * Интерфейс для юнит-тестирования задания №10.
 *
 * Задан файл, содержащий английские слова (без знаков препинания).
 * Требуется выделить все различные слова и посчитать частоту их встречаемости.
 * Слова, отличающиеся регистром букв, считать различными.
 * Использовать класс HashMap.
 */
public interface ITestableTask10 extends ITaskStorage.ITestableTask {

    /**
     * Подсчитывает количество вхождений каждого слова в файле.
     * @param input Файл с исходными данными.
     * @return Множество пар <слово, количество вхождений в файле>.
     */
    HashMap<String, Integer> countNumberWords(File input);
}