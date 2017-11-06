package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask16;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class Task16 implements ITestableTask16 {

    @Override
    public IFileWithPoints analyze(I2DPoint center, int radius, File output) {
        double xCenter = center.getX();
        double yCenter = center.getY();
        FileWithPoints result = new FileWithPoints(output);
        SortedMap<I2DPoint, Double> map = new TreeMap<>(
                Comparator.comparingDouble(point -> result.distance(center, point)));

        for (int x = (int) round(xCenter - radius); x < (int) round(xCenter + radius); x++) {
            for (int y = (int) round(yCenter - radius); y < (int) round(yCenter + radius); y++) {
                I2DPoint point = new Point2D(x, y);
                double distance = result.distance(center, point);
                if (distance < radius) {
                    map.put(point, distance);
                }
            }
        }

        result.writePointsToFile(center, map);
        return result;
    }

    private class FileWithPoints implements IFileWithPoints {

        private File file;

        public FileWithPoints(File file) {
            this.file = file;
        }

        public void writePointsToFile(I2DPoint center, SortedMap<I2DPoint, Double> map) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(String.valueOf(center.getX()) + " ");
                writer.write(String.valueOf(center.getY()) + "\n");

                for (I2DPoint point : map.keySet()) {
                    writer.write(String.valueOf(point.getX()));
                    writer.write(' ');
                    writer.write(String.valueOf(point.getY()));
                    writer.write(' ');
                    writer.write(String.valueOf(map.get(point)));
                    writer.write('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public File getFile() {
            return file;
        }

        private double distance(I2DPoint center, I2DPoint point) {
            double x = center.getX() - point.getX();
            double y = center.getY() - point.getY();
            return sqrt(x * x + y * y);
        }

        @Override
        public SortedMap<I2DPoint, Double> getPoints() {
            SortedMap<I2DPoint, Double> result = new TreeMap<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String s = reader.readLine();
                String[] splited = s.split("\\s");
                final I2DPoint center = new Point2D(Double.parseDouble(splited[0]), Double.parseDouble(splited[1]));
                result = new TreeMap<>(Comparator.comparingDouble(point -> distance(center, point)));

                while ((s = reader.readLine()) != null) {
                    splited = s.split("\\s");
                    I2DPoint point = new Point2D(Double.parseDouble(splited[0]), Double.parseDouble(splited[1]));
                    Double value = Double.parseDouble(splited[2]);
                    result.put(point, value);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }
    }

    private class Point2D implements I2DPoint {

        private double x;
        private double y;

        public Point2D(double x, double y) {
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
}
