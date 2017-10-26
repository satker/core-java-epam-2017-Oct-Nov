package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask4;

import java.util.HashSet;
import java.util.Set;

public class Task4 implements ITestableTask4 {

    /*
    public static void main(String[] args) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        Task4 task = new Task4();

        first.add(4); first.add(8); first.add(7);
        second.add(8); second.add(5); second.add(9);

        System.out.println(task.intersection(first, second));
        System.out.println(task.union(first, second));
    }
    */

    @Override
    public Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersectionSet = new HashSet<>(first);
        intersectionSet.retainAll(second);
        return intersectionSet;
    }

    @Override
    public Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> unionSet = new HashSet<>(first);
        unionSet.addAll(second);
        return unionSet;
    }
}
