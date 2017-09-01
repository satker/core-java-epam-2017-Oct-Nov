package com.epam.courses.jf.se7;

public class OperationInspector {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(200);
        OperatorDeposit opD = new OperatorDeposit(null);
        OperatorWithdraw opW = new OperatorWithdraw(null);

        opD.start();
        opW.start();

        opD.join();
        opW.join();

        System.out.println(account.getBalance());
    }
}

