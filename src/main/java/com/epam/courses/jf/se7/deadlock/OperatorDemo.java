package com.epam.courses.jf.se7.deadlock;

public class OperatorDemo {

    public static void main(String[] args) {
        Account acc1 = new Account(200);
        Account acc2 = new Account(300);

        Operator op1 = new Operator(acc1, acc2, 1);
        Operator op2 = new Operator(acc2, acc1, 2);

        op1.start();
        op2.start();
        System.out.println("Started");
    }
}

