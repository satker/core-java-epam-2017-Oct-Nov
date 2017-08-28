package com.epam.courses.jf.se6;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.BitSet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BitSetExample {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(10);
        // 000000000000....10000000001
        System.out.println(bitSet.length());
        System.out.println(bitSet.size());

        BitSet bitSet2 = new BitSet();
        bitSet2.set(0);

        bitSet.xor(bitSet2);
        System.out.println(bitSet);

        List<Integer> list = new LinkedList<>();
        List<Integer> synchro = Collections.synchronizedList(list);
        List<Integer> unmodifiable = Collections.unmodifiableList(list);
//        unmodifiable.add(1);

        List rawList = list;
        List checkedList = Collections.checkedList(list, Integer.class);
        checkedList.add("Hello");
        System.out.println(rawList.get(0));
    }
}
