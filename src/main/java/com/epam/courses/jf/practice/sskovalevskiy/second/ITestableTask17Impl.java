package com.epam.courses.jf.practice.sskovalevskiy.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask17;

import java.util.*;

/**
 * Created by asus on 29.10.2017.
 */
public class ITestableTask17Impl implements ITestableTask17 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

//        https://ru.wikipedia.org/wiki/Прямая
//        Уравнение прямой, проходящей через две заданные несовпадающие точки в общем виде:
//        (y1 - y2)*x + (x2 - x1)*y + (x1*y2 - x2*y1) = 0

//        Две прямые, заданные уравнениями
//        A1*x + B1*y + C1 = 0 и A2*x + B2*y + C2 = 0
//        пересекаются в точке
//        x = (B1C2 - B2C1)/(A1B2 - A2B1) , y = (C1A2 - C2A1)/(A1B2 - A2B1)

//        Map<I2DPoint, Double> map = new TreeMap<>(new Comparator<I2DPoint>() {
//            @Override
//            public int compare(I2DPoint o1, I2DPoint o2) {
//                return (int)(o1.getX() - o2.getX());
//            }
//        });

        Set<I2DPoint> resultSet = new HashSet<>();


        ArrayList<ISegment> iSegments = new ArrayList<>(segments);

        for (int i = 0; i < iSegments.size() - 1; i++) {
            I2DPoint firstPoint = iSegments.get(i).first();
            I2DPoint secondPoint = iSegments.get(i).second();
            double A1 = firstPoint.getY() - secondPoint.getY();
            double B1 = secondPoint.getX() - firstPoint.getX();
            double C1 = firstPoint.getX() * secondPoint.getY() - secondPoint.getX() * firstPoint.getY();

            double minAbscissa = Double.MAX_VALUE;

            for (int j = i + 1; j < iSegments.size(); j++) {
                I2DPoint thirdPoint = iSegments.get(i).first();
                I2DPoint forthPoint = iSegments.get(i).second();
                double A2 = thirdPoint.getY() - forthPoint.getY();
                double B2 = forthPoint.getX() - thirdPoint.getX();
                double C2 = thirdPoint.getX() * forthPoint.getY() - forthPoint.getX() * thirdPoint.getY();

                double x = (B1 * C2 - B2 * C1) / (A1 * B2 - A2 * B1);
                double y = (C1 * A2 - C2 * A1) / (A1 * B2 - A2 * B1);

                if (firstPoint.getX() <= x && x <= secondPoint.getX() && firstPoint.getY() <= y && y <= secondPoint.getY() &&
                        thirdPoint.getX() <= x && x <= forthPoint.getX() && thirdPoint.getY() <= y && y <= forthPoint.getY()) {
//                    map.put(new I2DPointImpl(x, y), x);
                    if (x < minAbscissa) {
                        minAbscissa = x;
                        resultSet.clear();
                        resultSet.add(new I2DPointImpl(x, y));
                    } else if (x == minAbscissa) {
                        resultSet.add(new I2DPointImpl(x, y));
                    }
                }
            }
        }

        return resultSet;
    }

    class I2DPointImpl implements I2DPoint {
        double x;
        double y;

        public I2DPointImpl(double x, double y) {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            I2DPointImpl i2DPoint = (I2DPointImpl) o;

            if (Double.compare(i2DPoint.x, x) != 0) return false;
            return Double.compare(i2DPoint.y, y) == 0;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(x);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(y);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}
