import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMain {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Creating accounts using the initial data from the previous assignment
        accounts.add(new BankAccount("Christina Holland", 500.00, "12345"));
        accounts.add(new BankAccount("Chloe Evans", 5000.00, "67890"));
        accounts.add(new BankAccount("Brittany Bowen", 300.00, "13579"));

        //Using a while loop for the login menu
        while (true) {
            System.out.println("Welcome to the Bank Account Management System");
            System.out.println("1. Create a new account");
            System.out.println("2. Select an existing account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            //Handling the user's input choices
            if (choice == 1) {
                createAccount();
            } else if (choice == 2) {
                selectAccount();
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //Creating a method to create a new account
    private static void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter starting balance: ");
        double balance = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount newAccount = new BankAccount(name, balance, accountNumber);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");

        mainMenu(newAccount);
    }

    //Creating a method to select an existing account and interact with it
    private static void selectAccount() {
        System.out.print("Enter the account number to select: ");
        String accountNumber = scanner.nextLine();
        BankAccount selectedAccount = findAccountByNumber(accountNumber);

        if (selectedAccount != null) {
            mainMenu(selectedAccount);
        } else {
            System.out.println("Account not found.");
        }
    }

    //Creating a method to find an account by its number
    private static BankAccount findAccountByNumber(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    //Creating a method to display the main menu for an account
    private static void mainMenu(BankAccount account) {
        System.out.println("Welcome, " + account.getCustomerName());

        //Using a while loop for the banking interactions menu
        while (true) {
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            //Handling the user's input choices
            if (choice == 1) {
                account.printAccountDetails();
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double amount = Double.parseDouble(scanner.nextLine());
                account.deposit(amount);
            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double amount = Double.parseDouble(scanner.nextLine());
                account.withdrawal(amount);
            } else if (choice == 4) {
                System.out.print("Enter account number to transfer to: ");
                String toAccountNumber = scanner.nextLine();
                BankAccount toAccount = findAccountByNumber(toAccountNumber);

                //Handling option 4 (transferring money)
                if (toAccount != null) {
                    System.out.print("Enter amount to transfer: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.transfer(toAccount, amount);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 5) {
                System.out.println("Exiting to main menu...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
