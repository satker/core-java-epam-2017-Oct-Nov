package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

public class Task16Impl implements ITestableTask16 {

    // sqrt ((x - center_x)^2 + (y - center_y)^2) < radius => inside

    @Override
    public IFileWithPoints analyze(I2DPoint center, int radius, File output) {
        SortedMap<I2DPoint, Double> map = new TreeMap<>((o1, o2) ->
                (countDistance(o1.getX(), o1.getY(), center.getX(), center.getY()) < (countDistance(o2.getX(), o2.getY(), center.getX(), center.getY())) ? -1 : 1));
        for (double i = (int) (center.getX() - radius); i <= (int) (center.getX() + radius); ++i) { // for x
            for (double j = (int) (center.getY() - radius); j <= (int) (center.getY() + radius); ++j) {// for y
                double distance = countDistance(i, j, center.getX(), center.getY());
                if (distance < radius)
                    map.put(new SinglePoint(i, j), distance);
            }
        }

        try (FileWriter fileWriter = new FileWriter(output)) {
            for (I2DPoint key : map.keySet()) {
                fileWriter.write(key.getX() + ", " + key.getY() );
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new MyFile(output, map);
    }

    public class SinglePoint implements I2DPoint {

        double x;
        double y;

        public SinglePoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }
    }

    public double countDistance(double firstX, double firstY, double secondX, double secondY) {
        return Math.sqrt(Math.pow(firstX - secondX, 2) + Math.pow(firstY - secondY, 2));
    }

    public class MyFile implements IFileWithPoints {

        File file;
        SortedMap<I2DPoint, Double> map;

        public MyFile(File file, SortedMap<I2DPoint, Double> map) {
            this.file = file;
            this.map = map;
        }

        @Override
        public File getFile() {
            return file;
        }

        @Override
        public SortedMap<I2DPoint, Double> getPoints() {
            return map;
        }
    }
}
