import java.util.Scanner;

public class ATMSystem {

    static class Account {
        private int accountNumber;
        private String accountHolder;
        private double balance;

        public Account(int accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful! New balance: " + balance);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful! New balance: " + balance);
            } else {
                System.out.println("Insufficient funds or invalid withdrawal amount.");
            }
        }

        public void showBalance() {
            System.out.println("Current Balance: " + balance);
        }

        public void showDetails() {
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Account Number: " + accountNumber);
            showBalance();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Account Holder Name: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double initialDeposit = scanner.nextDouble();

        Account account = new Account(accountNumber, accountHolder, initialDeposit);
        int option;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter an option: ");
            option = scanner.nextInt();

            if (option == 1) {
                account.showDetails();
            } else if (option == 2) {
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
            } else if (option == 3) {
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
            } else if (option == 4) {
                account.showBalance();
            } else if (option == 5) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid option. Please try again.");
            }

        } while (option != 5);

        scanner.close();
    }
}
