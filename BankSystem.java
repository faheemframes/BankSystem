// BankAccount.java
import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Check Balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Account info
    public void accountInfo() {
        System.out.println("\nAccount Holder: " + accountHolder);
        System.out.println("Account Balance: ₹" + balance);
    }
}

// Main class
public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        BankAccount account = new BankAccount(name, 0);
        int choice;

        do {
            System.out.println("\n====== BANK MENU ======");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ₹");
                    double amt = sc.nextDouble();
                    account.deposit(amt);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ₹");
                    double amt = sc.nextDouble();
                    account.withdraw(amt);
                }
                case 3 -> account.checkBalance();
                case 4 -> account.accountInfo();
                case 5 -> System.out.println(" Thank you for using our service!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}