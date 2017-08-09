package com.epam.courses.jf.se2.cloneable;

import java.io.FilePermission;
import java.util.Arrays;
import java.util.List;

public abstract class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Book book = new Book(100, "aqwe", Arrays.asList("1", "2", "3"));
        Book second = book.clone();
        System.out.println(book);
        System.out.println(second);
    }
}

class Book implements Cloneable {

    private static Book zombie;
    private final int price;
    private final String producer;
    private final List<String> paragraphs;

    Book(Book original) {
        price = original.price;
        producer = original.producer;
        paragraphs = original.paragraphs;
    }

    Book(int price, String producer, List<String> paragraphs) {
        this.price = price;
        this.producer = producer;
        this.paragraphs = paragraphs;
    }

    public Book clone() {
        try {
            Book base = (Book) super.clone();
            //base.paragraphs = paragraphs.clone();
            return base;
        } catch (CloneNotSupportedException ignored) {
            throw new RuntimeException(ignored);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (price != book.price) return false;
        return producer != null ? producer.equals(book.producer) : book.producer == null;

    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Price: " + price
                + " Producer: " + producer
                + " Paragraphs: " + paragraphs;
    }

    @Override
    protected void finalize() throws Throwable {
        zombie = new Book(this);
    }
}

class Zombie2 {

    static Zombie2 zombie;
    int value;

    public Zombie2(int value) {
        if(value < 0) {
            throw new IllegalArgumentException("Отрицательное значение Zombie2");
        }
        this.value = value;
    }

    @Override
    public void finalize() {
        zombie = this;
    }
}

class Vulnerable {

    Integer value = 0;

    private Vulnerable(int value, Object obj) {
        this.value = value;
    }

    public Vulnerable(int value) {
        this(checkValue(value), null);
    }

    private static int checkValue(int value) {
        SecurityManager manager = System.getSecurityManager();
        if(value <= 0) {
            throw new IllegalArgumentException("Значение Vulnerable должно быть положительным");
        }
        return value;
    }

    @Override
    public String toString() {
        return(value.toString());
    }

    public static void main(String[] args) {
        Vulnerable object = null;
        try {
            object = new Vulnerable(0);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        System.out.println(object);
    }
}


class AttackVulnerable extends Vulnerable {

    static Vulnerable vulnerable;

    public AttackVulnerable(int value) {
        super(value);
    }

    public void finalize() {
        vulnerable = this;
    }

    public static void main(String[] args) {
        try {
            new AttackVulnerable(-1);
        } catch(Exception e) {
            System.out.println(e);
        }
        System.gc();
        System.runFinalization();
        if(vulnerable != null) {
            System.out.println("Уязвимый объект " + vulnerable + " создан!");
        }
    }
}

class Insecure {
    Integer value = 0;

    public Insecure(int value) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            FilePermission fp = new FilePermission("index", "write");
            sm.checkPermission(fp);
        }
        this.value = value;
    }
    @Override
    public String toString() {
        return(value.toString());
    }
}

class AttackInsecure extends Insecure {
    static Insecure insecure;

    public AttackInsecure(int value) {
        super(value);
    }

    @Override
    public void finalize() {
        insecure = this;
    }
    public static void main(String[] args) {
        try {
            new AttackInsecure(-1);
        } catch(Exception e) {
            System.out.println(e);
        }
        System.gc();
        System.runFinalization();
        if(insecure != null) {
            System.out.println("Небезопасный объект " + insecure + " создан!");
        }
    }
}
