package com.epam.courses.jf.practice.vakhonin.second;

import com.epam.courses.jf.practice.common.second.I2DPoint;
import com.epam.courses.jf.practice.common.second.ITestableTask17;

import java.util.*;

import java.util.logging.*;
/**
 * Created by igorvahonin on 13.11.17.
 */
public class Task17 implements ITestableTask17{


    class Line {
        private double k, b;

        double getK(){
            return k;
        }

        double getB(){
            return b;
        }

        Line(ISegment segment){
            double x1,x2,y1,y2;
            x1 = segment.first().getX();
            x2 = segment.second().getX();
            y1 = segment.first().getY();
            y2 = segment.second().getY();
            k = (y2-y1)/(x2-x1);
            b = y1 - k * x1;
        }

        Point pointOfIntersection(Line line2){
            double k1,k2,b1,b2, x0,y0;

            k1 = this.getK();
            k2 = line2.getK();

            b1 = this.getB();
            b2 = line2.getB();

            x0 = (b2-b1)/(k1-k2);
            y0 = k1 * x0 + b1;

            Point result = new Point(x0,y0);

            return result;
        }

        boolean isParallel(Line line2) {
            if(this.getK() == line2.getK()){
                return true;
            }
            else{
                return false;
            }
        }

    }

    class Point implements I2DPoint{

        private double x,y;

        Point(double x, double y){
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

    static boolean isPointOfSegments(Point point, ISegment segment1, ISegment segment2){
        if(           (point.getX() >= segment1.first().getX()) && (point.getX() <= segment1.second().getX())   && (point.getY() >= segment1.first().getY())   && (point.getY() <= segment1.second().getY())         ){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        List<ISegment> segmentsList = new ArrayList<>(segments);
        List<Line> linesList = new ArrayList<>();
        Set<I2DPoint> pointsSet = new HashSet<>();
        Map<Double, Set<I2DPoint>> pointsMap= new TreeMap<>();


        for(ISegment segment: segmentsList){
            linesList.add(new Line(segment));
        }

        int size = segmentsList.size();
        Point point;
        Line lineJ, lineK;
        ISegment segmentJ, segmentK;

        for(int j = 0; j < size-1; j++){
            lineJ = linesList.get(j);
            segmentJ = segmentsList.get(j);
            for(int k = j+1; k<size; k++){
                lineK = linesList.get(k);
                segmentK = segmentsList.get(k);
                if(! lineJ.isParallel(lineK)){
                    point = lineJ.pointOfIntersection(lineK);
                    if(isPointOfSegments(point, segmentJ, segmentK)){
                        if(pointsMap.containsKey(point.getX())){
                            pointsMap.get(point.getX()).add(point);
                        }
                        else{
                            pointsMap.put(point.getX(), new HashSet<>());
                            pointsMap.get(point.getX()).add(point);
                        }
                    }

                }
            }
        }

        Iterator<Map.Entry<Double, Set<I2DPoint>>> it = pointsMap.entrySet().iterator();


        Logger log = Logger.getLogger(Task17.class.getName());

        Set<I2DPoint> result = it.next().getValue();


        log.info(result.toString());

        return result;
    }
}
