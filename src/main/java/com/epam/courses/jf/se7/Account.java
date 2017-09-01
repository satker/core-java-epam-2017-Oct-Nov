package com.epam.courses.jf.se7;

public class Account {

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public static synchronized void method() {
        Class<Account> clazz = Account.class;
        System.out.println("");
    }
}

