package com.epam.courses.jf.se2.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String s = newList(); // why does this line compile?
        Integer integer = newList(); // why does this line compile?
        System.out.println(s);
    }

    private static <T extends List<Integer>> T newList() {
        return (T) new ArrayList<Integer>();
    }
}
