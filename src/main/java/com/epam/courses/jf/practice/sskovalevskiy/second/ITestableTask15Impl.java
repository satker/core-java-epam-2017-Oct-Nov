package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask15;

import java.io.*;
import java.util.*;

/**
 * Created by asus on 26.10.2017.
 */
public class ITestableTask15Impl implements ITestableTask15 {

    @Override
    public IFileWithLines analyze(Set<I2DPoint> points, File output) {

        List<I2DPoint> pointsList = new ArrayList<>(points);
        HashMap<ABCMultipliers, Set<I2DPoint>> threePointsLine = new HashMap<>();

        for (int i = 0; i < pointsList.size() - 1; i++) {
            for (int j = i + 1; j < pointsList.size(); j++) {
                ABCMultipliers ABC = new ABCMultipliers(pointsList.get(i), pointsList.get(j));
                if (threePointsLine.containsKey(ABC)) {
                    threePointsLine.get(ABC).add(pointsList.get(j));
                } else {
                    threePointsLine.put(ABC, new HashSet<I2DPoint>());
                    threePointsLine.get(ABC).add(pointsList.get(i));
                    threePointsLine.get(ABC).add(pointsList.get(j));
                }

            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (Map.Entry<ABCMultipliers, Set<I2DPoint>> entry : threePointsLine.entrySet()) {
                if (entry.getValue().size() < 3) continue;

                Set<I2DPoint> i2DPoints = entry.getValue();
                for (I2DPoint i2DPoint : i2DPoints) {
                    writer.write(String.format(Locale.ENGLISH,"(%f;%f) ", i2DPoint.getX(), i2DPoint.getY()));
                }
                writer.write(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        IFileWithLines resultFile = new IFileWithLinesImpl(output);

        return resultFile;
    }

    class ABCMultipliers {
        private double A;
        private double B;
        private double C;

        public ABCMultipliers(I2DPoint point1, I2DPoint point2) {
            A = point2.getY() - point1.getY();
            B = point1.getX() - point2.getX();
            C = point1.getY() * point2.getX() - point1.getX() * point2.getY();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ABCMultipliers that = (ABCMultipliers) o;

            if (Double.compare(that.A, A) != 0) return false;
            if (Double.compare(that.B, B) != 0) return false;
            return Double.compare(that.C, C) == 0;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(A);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(B);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(C);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    class IFileWithLinesImpl implements IFileWithLines {
        File file;
        Set<ILine> iLines;

        public IFileWithLinesImpl(File file) {
            this.file = file;
        }

        @Override
        public File getFile() {
            return file;
        }

        @Override
        public Set<ILine> getLines() {

            iLines = new HashSet<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

                while (reader.ready()) {
                    String[] coordinates = reader.readLine().split(" \\(\\);");
                    Set<I2DPoint> points = new HashSet<>();
                    for (int i = 0; i < coordinates.length; i += 2) {
                        double x = Double.parseDouble(coordinates[i]);
                        double y = Double.parseDouble(coordinates[i + 1]);
                        points.add(new Point2D(x, y));
                    }
                    iLines.add(new Line(points));
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return iLines;
        }
    }

    class Line implements ILine {

        private final Set<I2DPoint> POINTS;

        public Line(Set<I2DPoint> points) {
            this.POINTS = points;
        }

        @Override
        public Set<I2DPoint> getPoints() {
            return POINTS;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Line line = (Line) o;

            return POINTS != null ? POINTS.equals(line.POINTS) : line.POINTS == null;
        }

        @Override
        public int hashCode() {
            return POINTS != null ? POINTS.hashCode() : 0;
        }
    }
}
