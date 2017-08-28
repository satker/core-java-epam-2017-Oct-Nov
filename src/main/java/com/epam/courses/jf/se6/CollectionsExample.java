package com.epam.courses.jf.se6;

import java.util.Arrays;
import java.util.List;

public class CollectionsExample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] arr = (Integer[]) list.toArray();

        Integer[] array = new Integer[list.size() - 1];
        Integer[] newArray = list.toArray(array);
        if (array == newArray) {
            System.out.println("Equals length");
        }

        System.out.println(Arrays.toString(newArray));
    }
}
