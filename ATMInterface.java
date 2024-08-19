import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initial balance of $1000
        AtmMachine atm = new AtmMachine(account);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            atm.displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter withdraw amnount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    running = true;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    running = true;
                case 3:
                    atm.checkBalance();
                    running = true;
                case 4:
                    System.out.println("Have a good day!");
                    running = false;
                default:
                    if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                        System.out.println("Invalid option. Please try again.");
                    }
            }
            scanner.close();
        }
    }
}

// 1.Create a class to represent the ATM machine.
class AtmMachine {
    private BankAccount account;

    public AtmMachine(BankAccount account) {
        this.account = account;
    }

    /*
     * 2. Design the user interface for the ATM, including options such as
     * withdrawing, depositing, and checking the balance.
     */
    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw \n2. Deposit \n3. Check Balance \n4. Exit");
        System.out.print("Please choose an option: ");
    }

    /*
     * 3. Implement methods for each option, such as withdraw(amount),
     * deposit(amount), and checkBalance().
     */
    // Withdraw, Deposit, Check Balance method:
    public void withdraw(double amount) {
        if (account.getBalance() >= amount && amount > 0) { // Validate user input
            account.withdraw(amount);
            System.out.println("Withdrawal of $" + amount + " was successful.");
        } else {
            System.out.println("Insufficient funds/invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit of $" + amount + " is successful.");
        } else {
            System.out.println("Incorrect deposit.");
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is; $" + account.getBalance());// Display appropriate messages
    }

}

// Create a class to represent the user's bank account, which stores the account
// balance.
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Get the balance withdraw and depsit method:
    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal failed. Please try again.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit failed. Please try again.");
        }
    }
}