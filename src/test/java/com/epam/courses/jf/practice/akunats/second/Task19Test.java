package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.ITestableTask19;
import groovy.util.GroovyTestCase;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Task19Test extends GroovyTestCase {
    @Test
    void getNumberOvertaking() {
        Car c1 = new Car(1,3);
        Car c2 = new Car(2,2);
        Car c3 = new Car(0, 5);
        Set<ITestableTask19.ICar> cars = new HashSet<>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        System.out.println(new Task19().getNumberOvertaking(cars, 10,5));
    }

}