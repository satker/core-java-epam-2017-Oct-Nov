package com.epam.courses.jf.se4;

import java.io.*;
import java.util.Objects;

public class Serialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SimpleClass object = new SimpleClass();

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteStream);
        outputStream.writeObject(object);

        byte[] serialized = byteStream.toByteArray();
        System.out.println("Length of serialized object = " + serialized.length);
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(serialized));
        SimpleClass obj = (SimpleClass)inputStream.readObject();

        System.out.println(object == obj);
        System.out.println(object.equals(obj));
        System.out.println(obj.getB() + " " + object.getB());
    }
}

class NotSerializableClass {

}

class SimpleClass implements Serializable {

    transient int b = 2000;
    int a = 10;

    public SimpleClass() {
        System.out.println("Hello");
    }

    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleClass that = (SimpleClass) o;
        return b == that.b &&
                a == that.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(b, a);
    }
}
