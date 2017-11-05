package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Task15 implements ITestableTask15 {

    @Override
    public IFileWithLines analyze(Set<I2DPoint> points, File output) {

        Set<ILine> lines = new HashSet<>();

        for (I2DPoint firstPoint : points) {
            Set<I2DPoint> set = new HashSet<>();
            set.add(firstPoint);
            double x1 = firstPoint.getX();
            double y1 = firstPoint.getY();

            for (I2DPoint secondPoint : points) {
                double x2 = secondPoint.getX();
                double y2 = secondPoint.getY();
                if (x1 != x2 || y1 != y2) {
                    set.add(secondPoint);

                    for (I2DPoint thirdPoint : points) {
                        double x3 = thirdPoint.getX();
                        double y3 = thirdPoint.getY();
                        if ((x1 != x3 || y1 != y3) && (x2 != x3 || y2 != y3) &&
                                ((x3 - x1) * (y2 - y1) == (x2 - x1) * (y3 - y1))) {
                            set.add(thirdPoint);
                        }
                    }
                }
            }

            if (set.size() > 2) {
                lines.add(new Line(set));
            }
        }

        return new FileWithLines(output, lines);

    }

    private class FileWithLines implements IFileWithLines {

        private File file;

        FileWithLines(File file) {
            this.file = file;
        }

        FileWithLines(File file, Set<ILine> lines) {
            this(file);
            writeLinesToFile(lines);
        }

        public void writeLinesToFile(Set<ILine> lines) {

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
                outputStream.writeObject(lines);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public File getFile() {
            return file;
        }

        @Override
        public Set<ILine> getLines() {
            Set<ILine> result = new HashSet<>();

            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                result = (Set<ILine>) inputStream.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }

            return result;
        }
    }

    private class Line implements ILine, Serializable {

        private Set<I2DPoint> set = new HashSet<>();

        Line(Set<I2DPoint> set) {
            this.set = set;
        }

        @Override
        public Set<I2DPoint> getPoints() {
            return set;
        }
    }


}
