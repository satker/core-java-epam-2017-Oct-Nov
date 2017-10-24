package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.ITestableTask14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Task14 implements ITestableTask14 {

    public <T extends Number> INumberCollection<T> createCollection(Class<T> required) {
        return new MyNumberCollection<T>();
    }

    private class MyNumberCollection<T extends Number> implements INumberCollection {
        List<T> repository = new ArrayList<>();

        @Override
        public Number nearest(Number value) {
            Number resultNumber = 0;
            for (T t : repository) {
                if (t.equals(value)) {
                    resultNumber = t;
                    break;
                }
                if (resultNumber.equals(0)
                        || Math.abs(Double.parseDouble(value.toString()) - Double.parseDouble(t.toString()))
                        < Math.abs(Double.parseDouble(value.toString()) - Double.parseDouble(resultNumber.toString()))) {
                    resultNumber = t;
                }
            }
            return resultNumber;
        }

        @Override
        public int size() {
            int size = 0;
            for (T t : repository) {
                size++;
            }
            return size;
        }

        @Override
        public boolean isEmpty() {
            return repository.size() == 0;
        }

        @Override
        public boolean contains(Object o) {
            int i = 0;
            for (T t : repository) {
                if (t.equals(o)) {
                    i++;
                }
            }
            return i > 0;
        }

        @Override
        public Iterator iterator() {
            return repository.listIterator();
        }

        @Override
        public Object[] toArray() {
            Object[] toArray = new Object[repository.size()];
            for (int i = 0; i < repository.size(); i++) {
                toArray[i] = repository.get(i);
            }
            return toArray;
        }

        @Override
        public boolean add(Object o) {
            return repository.add((T) o);
        }

        @Override
        public boolean remove(Object o) {
            boolean result = false;
            Iterator<T> iter = repository.iterator();
            while (iter.hasNext()) {
                T next = iter.next();
                if (next.equals(o)) {
                    iter.remove();
                    result = true;
                }
            }
            return result;
        }

        @Override
        public boolean addAll(Collection c) {
            return repository.addAll(c);
        }

        @Override
        public void clear() {
            Iterator<T> iter = repository.iterator();
            while (iter.hasNext()) {
                iter.next();
                iter.remove();
            }
        }

        @Override
        public boolean retainAll(Collection c) {
            repository.removeIf(next -> !next.equals(repository.get(repository.indexOf(c))));
            return true;
        }

        @Override
        public boolean removeAll(Collection c) {
            int startSize = repository.size();
            boolean result = false;
            repository.removeIf(next -> next.equals(repository.get(repository.indexOf(c))));
            if (startSize - c.size() == repository.size()) {
                result = true;
            }
            return result;
        }

        @Override
        public boolean containsAll(Collection c) {
            return stream().allMatch(i -> repository.contains(i));
        }

        @Override
        public Object[] toArray(Object[] a) {
            Object[] toArray = new Object[repository.size()];
            for (int i = 0; i < repository.size(); i++) {
                for (Object anA : a) {
                    if (repository.get(i).equals(anA)) {
                        toArray[i] = repository.get(i);
                    }
                }
            }
            return toArray;
        }
    }
}
