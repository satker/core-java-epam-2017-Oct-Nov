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
//        private double k, b;
//        Ax + By + C = 0
        private double a, b, c;

        double getA(){
            return a;
        }

        double getB(){
            return b;
        }

        double getC(){
            return c;
        }

        Line(ISegment segment){
            double x1,x2,y1,y2;
            x1 = segment.first().getX();
            x2 = segment.second().getX();
            y1 = segment.first().getY();
            y2 = segment.second().getY();

            if((x2-x1) == 0){
                this.b = 0;
            }
            else {
                this.b = 1;
                this.a = (y2 - y1) / (x2 - x1);
                this.c = y1 - a * x1;
            }
        }

        Point pointOfIntersection(Line line2){
            double a1,a2,b1,b2, c1, c2, x0,y0;

            a1 = this.getA();
            a2 = line2.getA();

            b1 = this.getB();
            b2 = line2.getB();

            c1 = this.getC();
            c2 = line2.getC();

            y0 = (a2*c1/a1 - c2)/(b2-b1*a2/a1);
            x0 = -c1-b1*y0;

            Point result = new Point(x0,y0);

            return result;
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
        Logger log = Logger.getLogger(Task17.class.getName());

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

            log.info("J: first - (" + segmentJ.first().getX() + " " + segmentJ.first().getY() + ");   second - ("+ segmentJ.second().getX() + " " + segmentJ.second().getY() + ")");
            log.info("lineJ: a = " + lineJ.getA()+ "  b="+ lineJ.getB()+ "  c="+ lineJ.getC());
            for(int k = j+1; k<size; k++){
                lineK = linesList.get(k);
                segmentK = segmentsList.get(k);
                log.info("K: first - (" + segmentK.first().getX() + " " + segmentK.first().getY() + ");   second - ("+ segmentK.second().getX() + " " + segmentK.second().getY() + ")");
                log.info("lineK: a = " + lineK.getA()+ "  b="+ lineK.getB()+ "  c="+ lineK.getC());
//                log.info("parallel? " + lineJ.isParallel(lineK));
                point = lineJ.pointOfIntersection(lineK);
                if(isPointOfSegments(point, segmentJ, segmentK)){
//                    log.info("intersection!!!");
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


        log.info(pointsMap.toString());
        Iterator<Map.Entry<Double, Set<I2DPoint>>> it = pointsMap.entrySet().iterator();



        Set<I2DPoint> result = it.next().getValue();




        return result;
    }
}
