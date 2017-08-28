package com.epam.courses.jf.se6;

import java.util.*;

public class SetsExample {

    public static void main(String[] args) {
        priorityQueueExample();
    }

    private static void descendingSetExample() {
        NavigableSet<Integer> first = new TreeSet<>(Arrays.asList(1, 5, 7, 8));
        for (Integer curr : first) {
            System.out.println(curr);
        }

        Set<Integer> descending = first.descendingSet();
        for (Integer curr : descending) {
            System.out.println(curr);
        }

        System.out.println();
        descending.add(1000);
        for (Integer curr : first) {
            System.out.println(curr);
        }
    }

    private static void method() {
        Set<B> set = new HashSet<>();
        set.add(new B(1));
        set.add(new B(2));
        System.out.println(set.add(new B(2)));
        System.out.println(set.size());
    }

    private static void nonComparable() {
        Set<B> treeSet = new TreeSet<>((l, r) -> Integer.compare(l.getValue(), r.getValue()));
        treeSet.add(new B(1));
        treeSet.add(new B(3));
        treeSet.add(new B(2));
        System.out.println(treeSet);
    }

    private static void iterateAndRemove() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            Integer integer = iter.next();
            if (integer < 4) {
                iter.remove();
            }
        }

        for (Integer integer : list) {
            if (integer < 4) {
                list.remove(integer);
            }
        }
    }

    private static void priorityQueueExample() {
        PriorityQueue<String> queue1 = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.length(), o2.length()));
        queue1.offer("Oklahoma");
        queue1.offer("Indiana");
        queue1.offer("Georgia");
        queue1.offer("Texas");
        System.out.println("Priority queue using Comparable:");
        while (queue1.size() > 0) {
            System.out.print(queue1.poll() + " ");
        }
    }
}




class B {

    private final int value;

    B(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return value == B.class.cast(obj).value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public int getValue() {
        return value;
    }
}