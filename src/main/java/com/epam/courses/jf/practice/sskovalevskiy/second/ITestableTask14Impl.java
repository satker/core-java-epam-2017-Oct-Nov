package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.ITestableTask14;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by asus on 01.11.2017.
 */
public class ITestableTask14Impl implements ITestableTask14 {
    @Override
    public <T extends Number> INumberCollection<T> createCollection(Class<T> required) {
        return new NumberCollection<T>();
    }

    class NumberCollection<T extends Number> extends ArrayList<T> implements ITestableTask14.INumberCollection<T> {

        @Override
        public T nearest(T value) {

            return stream()
                    .min(Comparator.comparingDouble(o -> Math.abs(o.doubleValue() - value.doubleValue())))
                    .get();
        }
    }
}
