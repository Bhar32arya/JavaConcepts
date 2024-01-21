package org.example;
class Account {
    private double initialBalance;
    public Account(double initialBalance) {
        this.initialBalance = initialBalance;
    }
    public synchronized void withdrawal(int amount) {
        if (amount > 0 && amount <= initialBalance) {
            initialBalance = initialBalance - amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount);
            System.out.println("Remaining balance: $" + initialBalance);
        } else {
            System.out.println(Thread.currentThread().getName() + " could not withdraw. Insufficient funds or invalid amount.");
        }
    }
}
class AccountThread extends Thread {
    private final Account account;
    private final int withdrawalAmount;
    AccountThread(String name, Account account, int withdrawalAmount) {
        super(name);
        this.account = account;
        this.withdrawalAmount = withdrawalAmount;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is attempting to withdraw: $" + withdrawalAmount);
            account.withdrawal(withdrawalAmount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class ATMMachine {
    public static void main(String[] args) {
        Account account = new Account(1000);
        Thread one = new AccountThread("Bhar32", account, 500);
        Thread two = new AccountThread("Arya", account, 300);
        Thread three = new AccountThread("Person", account, 300);
        one.start();
        two.start();
        three.start();
    }
}