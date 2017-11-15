package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask15;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Task15 implements ITestableTask15 {
    public IFileWithLines analyze(Set<I2DPoint> points, File output) {
        Set<ILine> linesFound = new HashSet<>();
        for (I2DPoint point1 : points) {
            double x1 = point1.getX();
            double y1 = point1.getY();
            for (I2DPoint point2 : points) {
                double x2 = point2.getX();
                double y2 = point2.getY();
                for (I2DPoint point3 : points){
                    double x3 = point3.getX();
                    double y3 = point3.getY();
                    if ((x3 - x1)*(y2 - y1) == (y3 - y1)*(x2 - x1)) {
                        HashSet<I2DPoint> pointsFound = new HashSet<>();
                        pointsFound.add(point1);
                        pointsFound.add(point2);
                        pointsFound.add(point3);
                        linesFound.add(new Line(pointsFound));
                    }
                }
            }
        }
        return new FileWithLines(linesFound, output);
    }

    private class FileWithLines implements IFileWithLines {

        File file;

        FileWithLines (Set<ILine> lines, File file) {
            this.file = file;
            writeLines(lines);
        }

        @Override
        public File getFile() {
            return file;
        }


        public void writeLines(Set<ILine> lines) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (ILine line : lines) {
                    for (I2DPoint point : line.getPoints()) {
                        writer.write(String.valueOf(point.getX()));
                        writer.write(", ");
                        writer.write(String.valueOf(point.getY()));
                        writer.write(" ");
                    }
                    writer.write("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Set<ILine> getLines() {
            Set<ILine> lines = new HashSet<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String string;
                while ((string = reader.readLine()) != null) {
                    String[] row = string.split("\\s");
                    Set<I2DPoint> currentPoints = new HashSet<>();
                    for (int i = 0; i < row.length; i+=3) {
                        Point currentPoint = new Point(Double.parseDouble(row[i]), Double.parseDouble(row[i+1]));
                        currentPoints.add(currentPoint);
                    }
                    lines.add(new Line(currentPoints));
                }
                return lines;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lines;
        }
    }

    private class Point implements I2DPoint {

        private double x, y;

        public Point (double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public double getY() {
            return x;
        }

        @Override
        public double getX() {
            return y;
        }
    }

    private class Line implements ILine {

        Set<I2DPoint> points;

        Line (Set<I2DPoint> points) {
            this.points = points;
        }

        @Override
        public Set<I2DPoint> getPoints() {
            return points;
        }
    }

}
