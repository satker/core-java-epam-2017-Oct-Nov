package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask17;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class Task17Test {
    @Test
    public void analyze() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 3);

        Point p3 = new Point(2, 4);
        Point p4 = new Point(2, 0);

        Point p5 = new Point(3, 1);
        Point p6 = new Point(1, 4);

        Point p7 = new Point(3.5, 4);
        Point p8 = new Point(5, 2);

        Point p9 = new Point(4, 1.5);
        Point p10 = new Point(5, 0.5);

        Point p11 = new Point(5, 1.5);
        Point p12 = new Point(4, 0.5);
        ITestableTask17.ISegment s1 = new Segment(p1, p2);
        ITestableTask17.ISegment s2 = new Segment(p3, p4);
        ITestableTask17.ISegment s3 = new Segment(p5, p6);
        ITestableTask17.ISegment s4 = new Segment(p7, p8);
        ITestableTask17.ISegment s5 = new Segment(p9, p10);
        ITestableTask17.ISegment s6 = new Segment(p11, p12);
        Set<ITestableTask17.ISegment> set = new HashSet<>();
        set.add(s1);
        set.add(s4);
        set.add(s2);
        set.add(s5);
        set.add(s3);
        set.add(s6);
        ArrayList<I2DPoint> result = new ArrayList<>(new Task17().analyze(set));
        ArrayList<I2DPoint> control = new ArrayList<>();
        control.add(new Point(4.5, 1.0));
        control.add(new Point(2.0, 2.5));
        control.add(new Point(2.0, 2.0));
        assertEquals(control.size(), result.size());
        for (int i = 0; i < control.size(); i++) {
            assertEquals(control.get(i).getX(), result.get(i).getX());
            assertEquals(control.get(i).getY(), result.get(i).getY());
        }
    }

}
