package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Task14Impl implements ITestableTask14 {
    @Override
    public <T extends Number> INumberCollection<T> createCollection(Class<T> required) {
        return new MyNumberCollection();
    }

    class MyNumberCollection<T extends Number> implements INumberCollection<T> {

        ArrayList<T> data;

        public MyNumberCollection() {
            data = new ArrayList<>();
        }

        @Override
        public Iterator<T> iterator() {
            return data.iterator();
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T1> T1[] toArray(T1[] a) {
            return (T1[]) data.toArray();
        }

        @Override
        public boolean add(T t) {
            return data.add(t);
        }

        @Override
        public boolean remove(Object o) {
            return data.remove(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return data.containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends T> c) {
            return data.addAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return data.removeAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return data.retainAll(c);
        }

        @Override
        public void clear() {
            data.clear();
        }

        @Override
        public int size() {
            return data.size();
        }

        @Override
        public boolean isEmpty() {
            return data.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return data.contains(o);
        }

        @Override
        public T nearest(T value) {
            T nearest = (T) ((Double) Double.MAX_VALUE);
            double lowestDelta = Double.MAX_VALUE;

            for (T number : data) {
                double delta = Math.abs((number.doubleValue() - value.doubleValue()));
                if (lowestDelta > delta) {
                    lowestDelta = delta;
                    nearest = number;
                }
            }
            return nearest;
        }
    }
}
