public class Account {
    private String accountName;
    private long accountNumber;
    private double balance;
    private int pin;

    public Account(String accountName, long accountNumber, double balance, int pin) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount);
        } else {
            System.out.print("Invalid amount");
        }
    }

    public void withdraw(double amount, int pin) {
        if (pin == this.pin) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                System.out.println("Withdrew " + amount);
            } else {
                System.out.println("Insufficient funds");
            }
        } else {
            System.out.println("Incorrect PIN");
        }

    }

    public double getBalance() {
        return balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void accountInfo(int pin) {
        if (pin == this.pin) {
            System.out.println("Account Name: " + accountName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Incorrect PIN");
        }
    }


}
