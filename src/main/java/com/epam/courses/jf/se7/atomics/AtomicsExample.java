package com.epam.courses.jf.se7.atomics;

import java.util.concurrent.atomic.*;

public class AtomicsExample {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        A a = new A();
        AtomicReference<A> atomicReference = new AtomicReference<>(a);
        AtomicStampedReference<A> aAtomicStampedReference = new AtomicStampedReference<>(a, 0);
        AtomicMarkableReference<A> aAtomicMarkableReference = new AtomicMarkableReference<>(a, true);
        aAtomicMarkableReference.compareAndSet(a, new A(), true, true);


        AtomicIntegerArray array = new AtomicIntegerArray(10);
        array.compareAndSet(0, 0, 10);


        AtomicIntegerFieldUpdater<A> updater = AtomicIntegerFieldUpdater.newUpdater(A.class, "value");
        int result = updater.accumulateAndGet(a, 1, (old, newValue) -> old + newValue);
    }
}

class A {
    volatile int value;


}