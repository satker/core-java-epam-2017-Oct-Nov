package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Task15Impl implements ITestableTask15 {
    @Override
    public IFileWithLines analyze(Set<I2DPoint> points, File output) {
       if (points.size() <= 2)
           return new MyFile(output, new HashSet<>());

       Set<SingleLine> allLines = new HashSet<>();
       for (I2DPoint firstPoint : points) {
           for (I2DPoint secondPoint : points) {
               if (firstPoint != secondPoint)
                   allLines.add(new SingleLine(firstPoint, secondPoint));
           }
       }

       for (SingleLine line : allLines) {
           for (I2DPoint thirdPoint : points) {
               if (!line.allPoints.contains(thirdPoint)) {
                   I2DPoint first = line.getFirstPoint();
                   I2DPoint second = line.getSecondPoint();
                   double firstPartOfEqualisation = (second.getY() - first.getY()) * (thirdPoint.getX() - first.getX());
                   double secondPartOfEqualisation = (thirdPoint.getY() - first.getY()) * (second.getX() - first.getX());
                   if (firstPartOfEqualisation == secondPartOfEqualisation) {
                       line.addPoint(thirdPoint);
                   }
               }
           }
       }

       try (FileWriter fileWriter = new FileWriter(output)) {
           for (SingleLine line : allLines) {
               fileWriter.write(line.getPoints().toString());
               fileWriter.write("\n");
           }
       } catch (IOException e) {
           e.printStackTrace();
       }

        return new MyFile(output, allLines);
    }

    // x1 y1; x2 y2; x3 y3;
    // (y2 - y1) / (x2 - x1) = (y3 - y1) / (x3 - x1) => (y2 - y1) (x3 - x1) = (y3 - y1) (x2 - x1)
    private class MyFile implements IFileWithLines {

        File file;
        Set<SingleLine> allLines;

        public MyFile(File file, Set<SingleLine> allLines) {
            this.file = file;
            this.allLines = allLines;
        }

        @Override
        public File getFile() {
            return file;
        }

        @Override
        public Set<ILine> getLines() {
            return new HashSet<>(allLines);
        }
    }

    public class SingleLine implements ILine {

        Set<I2DPoint> allPoints;
        I2DPoint firstPoint;
        I2DPoint secondPoint;

        public SingleLine(I2DPoint firstPoint, I2DPoint secondPoint) {
            allPoints = new HashSet<>();
            this.firstPoint = firstPoint;
            this.secondPoint = secondPoint;
            allPoints.add(firstPoint);
            allPoints.add(secondPoint);
        }

        public void addPoint(I2DPoint point) {
            allPoints.add(point);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof SingleLine && allPoints.equals(obj);
        }

        @Override
        public int hashCode() {
            return allPoints.size() == 0 ? 0 : allPoints.hashCode();
        }

        public I2DPoint getFirstPoint() {
            return firstPoint;
        }

        public I2DPoint getSecondPoint() {
            return secondPoint;
        }

        @Override
        public Set<I2DPoint> getPoints() {
            return allPoints;
        }
    }
}
