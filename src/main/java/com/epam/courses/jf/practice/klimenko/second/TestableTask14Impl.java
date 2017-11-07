package com.epam.courses.jf.practice.klimenko.second;

import com.epam.courses.jf.practice.common.second.ITestableTask14;

import java.util.*;

public class TestableTask14Impl implements ITestableTask14 {
    @Override
    public <T extends Number> INumberCollection<T> createCollection(Class<T> required) {
        return new NumberCollection<>();
    }

    private class NumberCollection<T extends Number> implements INumberCollection<T> {
        ArrayList<T> collection;

        NumberCollection() {
            collection = new ArrayList<>();
        }

        private int binarySearchWithCast(T value) {
            return Collections.binarySearch((List<? extends Comparable<Number>>) collection, value);
        }

        @Override
        public T nearest(T value) {
            if (isEmpty()) {
                return null;
            }
            int index = binarySearchWithCast(value);
            if (index >= 0) {
                return collection.get(index);
            }
            index = -index - 1;
            if (index == size()) {
                return collection.get(index - 1);
            }
            T a = collection.get(index);
            T b = collection.get(index - 1);
            return a.doubleValue() - value.doubleValue() < value.doubleValue() - b.doubleValue() ? a : b;
        }

        @Override
        public int size() {
            return collection.size();
        }

        @Override
        public boolean isEmpty() {
            return collection.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            int index = binarySearchWithCast((T) o);
            return index >= 0;
        }

        @Override
        public Iterator<T> iterator() {
            return collection.iterator();
        }

        @Override
        public Object[] toArray() {
            return collection.toArray();
        }

        @Override
        public <T1> T1[] toArray(T1[] t1s) {
            return collection.toArray(t1s);
        }

        @Override
        public boolean add(T t) {
            int index = binarySearchWithCast(t);
            if (index < 0) {
                collection.add(-index - 1, t);
                return true;
            }
            return false;
        }

        @Override
        public boolean remove(Object o) {
            int index = binarySearchWithCast((T) o);
            if (index >= 0) {
                collection.remove(index);
                return true;
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection2) {
            for (Object o : collection2) {
                if (!contains(o)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends T> collection2) {
            boolean ret = false;
            for (T o : collection2) {
                ret = ret || add(o);
            }
            return ret;
        }

        @Override
        public boolean removeAll(Collection<?> collection2) {
            boolean ret = false;
            for (Object o : collection2) {
                ret = ret || remove(o);
            }
            return ret;
        }

        @Override
        public boolean retainAll(Collection<?> collection2) {
            return collection.retainAll(collection2);
        }

        @Override
        public void clear() {
            collection.clear();
        }
    }
}
