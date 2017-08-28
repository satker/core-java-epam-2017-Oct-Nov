package com.epam.courses.jf.se6;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.WeakHashMap;

public class References {


    public static void main(String[] args) throws InterruptedException {
//        softReference();
//        phantomReference();
        weakHashMapExample();
    }

    private static void softReference() {
        A a = new A("1");
        SoftReference<A> reference = new SoftReference<>(a);

        a = null;

        // ... call GC

        A derefernce = reference.get();
        if (derefernce != null) {
            // ...
        }
    }

    private static void weakReference() {
        A a = new A("2");
        ReferenceQueue<A> referenceQueue = new ReferenceQueue<>();
        WeakReference<A> reference = new WeakReference<>(a, referenceQueue);

        a = null;
        // ... call GC

        A derefernce = reference.get();
        if (derefernce != null) {
            // ...
        }
    }

    private static void phantomReference() throws InterruptedException {
        A a = new A("First object");

        ReferenceQueue<A> referenceQueue = new ReferenceQueue<>();
        PhantomReference<A> reference = new ClassAFantomReference(a, referenceQueue);

        a = null;
        int[] arr = new int[10000000];
        System.gc();
        System.gc();

        int[] arr2 = new int[10000000];
        System.gc();

        ClassAFantomReference anotherReference = (ClassAFantomReference) referenceQueue.poll();
        if (anotherReference == reference) {
            System.out.println("Object " + anotherReference.getName() + " ready to destroy!");
            reference.clear();
        }

        int[] arr3 = new int[10000000];
        System.gc();
    }

    public static void weakHashMapExample() {
        WeakHashMap<A, String> map = new WeakHashMap<>();
        map.put(new A("key"), "value");

        System.out.println(map.size());
    }
}

class A {

    private final String name;

    A(String name) {
        this.name = name;
    }

    public void method() {
        System.out.println("Method in A");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalyze in class A");
    }

    public String getName() {
        return name;
    }
}

class ClassAFantomReference extends PhantomReference<A> {

    private final String name;

    public ClassAFantomReference(A referent, ReferenceQueue<? super A> q) {
        super(referent, q);
        name = referent.getName();
    }

    public String getName() {
        return name;
    }
}
