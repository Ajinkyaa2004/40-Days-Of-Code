// Problem 7: Bank Account (Interfaces)
// Goal: Understand interfaces and implementing them.
// Tasks:
// Create an interface named BankAccount with the following abstract methods:
// void deposit(double amount)
// void withdraw(double amount)
// double getBalance()
// Create a class SavingsAccount that implements the BankAccount interface.
// It should have a private balance instance variable.
// Implement all methods from the BankAccount interface.
// Add a check in withdraw to prevent withdrawing more than the current balance.
// In a main method (e.g., in BankApp class):
// Create an object of SavingsAccount.
// Perform a deposit, a withdrawal, and print the balance after each operation.
// Concepts Covered: Interfaces (interface, implements), Method implementation, Basic error handling within a method.

interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

class SavingsAccount implements BankAccount {
    private double balance;

    public SavingsAccount() {
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

public class BankApp {
    public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount();

        myAccount.deposit(5000);
        System.out.println("Current Balance: ₹" + myAccount.getBalance());

        myAccount.withdraw(1500);
        System.out.println("Current Balance: ₹" + myAccount.getBalance());

        myAccount.withdraw(4000); // Should trigger insufficient balance
        System.out.println("Current Balance: ₹" + myAccount.getBalance());
    }
}
