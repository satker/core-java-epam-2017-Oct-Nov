package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.ITestableTask6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task6 implements ITestableTask6 {
    public HashMap<Integer, Integer> addPolynomials(HashMap<Integer, Integer> first, HashMap<Integer, Integer> second) {
        HashMap<Integer, Integer> result = new HashMap<>();
        second.keySet().stream()
                .filter(i -> first.containsKey(second.get(i)) && second.get(i) != null && first.get(i) != null)
                .forEach(i -> result.put(i, first.get(i) + second.get(i)));
        for (Integer key : result.keySet()) {
            first.remove(key);
            second.remove(key);
        }
        result.putAll(first);
        result.putAll(second);
        return result;
    }

    public List<Integer> multiplyPolynomials(List<Integer> first, List<Integer> second) {
        List<Integer> result = new ArrayList<>();
        List<Integer> maxListSize = new ArrayList<>(first.size() >= second.size() ? first : second); // нходим коллекцию большей размерности
        // заполняем матрицу result возможным количеством нулей
        int lengthMin = first.size() <= second.size() ? first.size() - 1 : second.size() - 1;
        int lengthResult = 2 * lengthMin < maxListSize.size() ? maxListSize.size() - 1 : 2 * lengthMin;
        for (int i = 0; i <= lengthResult; i++) {
            result.add(i, 0);
        }
        //////
        for (int i = 0; i < maxListSize.size(); i++) {
            // если индекс содержится в двух коллецкиях
            // умножаем элементы (1) и записываем в индекс с сложенным показателем степени (2)
            if (i <= lengthMin) {
                if (i == 0) {
                    result.set(0, first.get(i) * second.get(i));
                } else {
                    result.set(i + i, //(2)
                            first.get(i) * second.get(i) // (1)
                                    + (i + i < maxListSize.size()
                                    && i + i >= (first.size() <= second.size() ? first.size() : second.size()) ?
                                    maxListSize.get(i + i) : 0));
                }
                //если индекс не содержится в двух коллецкиях, оставляем тот элемент из большей коллекции
            } else {
                if (result.get(i) == 0) {
                    result.set(i, maxListSize.get(i));
                }
            }
        }
        return result;
    }
}
