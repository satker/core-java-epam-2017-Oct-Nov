package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by asus on 29.10.2017.
 */
public class ITestableTask16Impl implements ITestableTask16 {
    @Override
    public IFileWithPoints analyze(I2DPoint center, int radius, File output) {
        TreeMap<I2DPoint, Double> result = new TreeMap<>((o1, o2) -> {
            if (Double.compare(getDistance(o1, center), getDistance(o2, center)) != -1)
                return 1;
            else
                return -1;
        });
        PriorityQueue<I2DPoint> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> getDistance(o, center)));

        for (int i = (int) center.getX() - radius; i < center.getX() + radius; i++) {
            for (int j = (int) center.getY() - radius; j < center.getY() + radius; j++) {
                I2DPoint current = new Point2D(i, j);
                if (getDistance(current, center) - radius < -Double.MIN_VALUE) {
                    queue.offer(current);
                }
            }
        }

        try (FileWriter fw = new FileWriter(output)) {
            while (queue.size() != 0) {
                I2DPoint current = queue.poll();
                result.put(current, getDistance(current, center));
                System.out.println(current.toString());
                fw.write(current.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new IFileWithPoints() {

            @Override
            public File getFile() {
                return output;
            }

            @Override

            public SortedMap<I2DPoint, Double> getPoints() {
                return result;
            }
        };
    }

    private double getDistance(I2DPoint point, I2DPoint center) {
        return Math.sqrt((point.getX() - center.getX()) * (point.getX() - center.getX())
                + (point.getY() - center.getY()) * (point.getY() - center.getY()));
    }
}
