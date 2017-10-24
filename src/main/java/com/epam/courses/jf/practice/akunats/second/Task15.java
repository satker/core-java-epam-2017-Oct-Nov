package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask15;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task15 implements ITestableTask15 {
    @Override
    public IFileWithLines analyze(Set<I2DPoint> points, File output) {
        //Set<String> result = new HashSet<>();
        ArrayList<I2DPoint> previousStep = new ArrayList<>();
        Set<ILine> lines = new HashSet<>();
        Iterator<I2DPoint> iter = points.iterator();
        while (iter.hasNext()) {
            I2DPoint point = iter.next();

            Set<I2DPoint> nextStep = new HashSet<>(points);//
            Iterator<I2DPoint> iterNext = nextStep.iterator();
            Set<I2DPoint> interList = new HashSet<>();
            while (iterNext.hasNext()) {
                I2DPoint pointForSearchEquation = iterNext.next();
                Set<I2DPoint> interSet = new HashSet<>();
                if (!pointForSearchEquation.equals(point)) {
                    // Считаем коэффициенты уравнение прямой Ax + By + C = 0
                    double A = pointForSearchEquation.getY() - point.getY();
                    double B = pointForSearchEquation.getX() - point.getX();
                    double C = point.getY() * (pointForSearchEquation.getX() - point.getX())
                            - point.getX() * (pointForSearchEquation.getY() - point.getY());
                    int countTrue = 0; // Подсчет колическтва точек удовлетворяющих уравнению
                    for (I2DPoint pointForSearch : points) {
                        if (!interList.contains(pointForSearch)) {
                            if (previousStep.size() == 0) {
                                if (!pointForSearch.equals(point)
                                        && !pointForSearch.equals(pointForSearchEquation)
                                        && (A * pointForSearch.getX() - B * pointForSearch.getY() + C) == 0) {
                                    interSet.add(pointForSearch);
                                    interList.add(pointForSearch);
                                    countTrue++;
                                }
                            } else {
                                for (I2DPoint p : previousStep) {
                                    if ((A * p.getX() - B * p.getY() + C) != 0) {
                                        if (!pointForSearch.equals(point)
                                                && !pointForSearch.equals(pointForSearchEquation)
                                                && (A * pointForSearch.getX() - B * pointForSearch.getY() + C) == 0) {
                                            interSet.add(pointForSearch);
                                            interList.add(pointForSearch);
                                            countTrue++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (countTrue > 0) {
                        interSet.add(point);
                        interSet.add(pointForSearchEquation);
                    }
                    interList.add(pointForSearchEquation);
                }
            }
            previousStep.add(point);
            iter.remove();
        }
        return new IFileWithLinesImpl(lines, output);
    }

    private class IFileWithLinesImpl implements IFileWithLines {
        private File file;
        private Set<ILine> lines;

        IFileWithLinesImpl(Set<ILine> points, File file) {
            this.file = file;
            this.lines = points;
        }

        @Override
        public File getFile() {
            return file;
        }

        @Override
        public Set<ILine> getLines() {
            return lines;
        }
    }

    private class ILineImpl implements ILine {
        Set<I2DPoint> set = new HashSet<>();

        ILineImpl(Set<I2DPoint> set) {
            this.set = set;
        }

        @Override
        public Set<I2DPoint> getPoints() {
            return set;
        }
    }
}
