package com.epam.courses.jf.se7.deadlock;

public class Operator extends Thread {

    private final Account account1;
    private final Account account2;

    public Operator(Account account1, Account account2, int number) {
        super("Operator thread " + number);
        this.account1 = account1;
        this.account2 = account2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            operationDeposit(10);
        }
    }

    private void operationDeposit(int depositSum) {
        synchronized (account1) {
            System.out.println("Заблокирован первый счет.");
            synchronized (account2) {
                System.out.println("Заблокирован второй счет.");
                account1.deposit(depositSum);
                account2.withdraw(depositSum);
            }
        }
    }
}
