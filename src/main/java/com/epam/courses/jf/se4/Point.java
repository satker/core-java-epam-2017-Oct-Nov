package com.epam.courses.jf.se4;

import java.io.*;
import java.util.Objects;

public class Point implements Serializable {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ") reference=" + super.toString();
    }
}

class Line implements Serializable {

    private static final long serialVersionUID = 10_000;

    transient public int value = 50;
    private Point point1;
    private Point point2;
    private int index;

    public Line() {
        System.out.println("Constructing empty line");
    }

    Line(Point p1, Point p2, int index) {
        System.out.println("Constructing line: " + index);
        this.point1 = p1;
        this.point2 = p2;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int newIndex) {
        index = newIndex;
    }

    public void printInfo() {
        System.out.println("Line: " + index);
        System.out.println(" Object reference: " + super.toString());
        System.out.println(" from point " + point1);
        System.out.println(" to point " + point2);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.writeInt(value);
        stream.writeObject(point1);
        stream.writeObject(point2);
        stream.writeInt(index);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        value = stream.readInt();
        point1 = (Point) stream.readObject();
        point2 = (Point) stream.readObject();
        index = stream.readInt();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return index == line.index &&
                Objects.equals(point1, line.point1) &&
                Objects.equals(point2, line.point2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, index);
    }

    @Override
    public String toString() {
        return "Line{" +
                "value=" + value +
                ", point1=" + point1 +
                ", point2=" + point2 +
                ", index=" + index +
                '}';
    }

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeInt(value);
//        out.writeObject(point1);
//        out.writeObject(point2);
//        out.writeInt(index);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        value = in.readInt();
//        point1 = (Point) in.readObject();
//        point2 = (Point) in.readObject();
//        index = in.readInt();
//    }
}

class Main2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(2.0, 2.0);
        Point p3 = new Point(3.0, 3.0);
        Line line1 = new Line(p1, p2, 1);
        Line line2 = new Line(p2, p3, 2);

        System.out.println("line 1 = " + line1);
        System.out.println("line 2 = " + line2);
        String fileName = "d:\\file";

//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
//            oos.writeObject(line1);
////            line1.setIndex(3);
////            oos.writeObject(line1);
//        }

        System.out.println("Read objects:");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Line line = (Line) ois.readObject();
            System.out.println(line);
        }
    }
}
