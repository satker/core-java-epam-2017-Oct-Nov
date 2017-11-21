package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Интерфейс для юнит-тестирования задания №11.
 *
 * В кругу стоят N человек.
 * На каждой итерации цикла выбывает человек (через одного, начиная с первого), пока не останется единственный.
 * Разработать два решения, моделирующие процесс.
 * Первое должно использовать класс ArrayList, а второе – LinkedList.
 */

public class Task11 implements ITestableTask11 {

    /**
     * Выполняет эмуляцию поставленной задачи.
     *
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */

    @Override
    public String emulate(ArrayList<String> peoples) {
        int i = 1;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                i++;
                iterator.next();
                if (i == 2) {
                    iterator.remove();
                    i = 0;
                }
            }
        }
        return peoples.get(0);
    }

    /**
     * Выполняет эмуляцию поставленной задачи.
     *
     * @param peoples Список с именами участников.
     * @return Имя последнего оставшегося.
     */

    @Override
    public String emulate(LinkedList<String> peoples) {
        int i = 1;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                i++;
                iterator.next();
                if (i == 2) {
                    iterator.remove();
                    i = 0;
                }
            }
        }
        return peoples.get(0);
    }
}
