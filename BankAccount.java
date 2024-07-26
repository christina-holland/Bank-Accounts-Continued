public class BankAccount {
    private double balance;
    private String customerName;
    private String accountNumber; // New attribute

    //Creating a constructor with all three attributes
    public BankAccount(String customerName, double balance, String accountNumber) {
        this.customerName = customerName;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    //Creating a no-parameter constructor for new accounts
    public BankAccount() {
        //These are placeholders for user input later
        this.customerName = "";
        this.balance = 0.0;
        this.accountNumber = "";
    }

    //Creating a method to set the account details from the user input
    public void setAccountDetails(String name, double balance, String accountNumber) {
        this.customerName = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    //Getter for the account number
    public String getAccountNumber() {
        return accountNumber;
    }

    //Getter for the customer name
    public String getCustomerName() {
        return customerName;
    }

    //Creating a method to deposit money into the customer's account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited. New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    //Creating a method to withdraw money from the customer's account
    public void withdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn. New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    //Creating a method to transfer money between two accounts
    public void transfer(BankAccount toAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdrawal(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred $" + amount + " to account " + toAccount.getAccountNumber());
        } else {
            System.out.println("Invalid transfer amount.");
        }
    }

    //Creating a method to print account details
    public void printAccountDetails() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: $" + balance);
    }
}
