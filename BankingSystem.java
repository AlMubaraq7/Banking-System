import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {
    private static ArrayList<Account> accounts = new ArrayList<Account>();
    private static Scanner scanner = new Scanner(System.in);

    private static void createAccount() {
        System.out.println("Enter Account Name: ");
        String name = scanner.next();
        System.out.println("Enter Account Number: ");
        long acctNo = scanner.nextLong();
        System.out.println("Enter balance: ");
        double bal = scanner.nextDouble();
        System.out.println("Enter PIN: ");
        int pin = scanner.nextInt();
        Account newAcct = new Account(name, acctNo, bal, pin);
        if (findAccount(acctNo) != null) {
            System.out.println("Account already exists!");
        } else {
            System.out.println("Creating account...");
            System.out.println("Account Created!");
            accounts.add(newAcct);
        }


    }

    private static void deposit() {
        Account account = findAccount();
        if (account != null) {
            System.out.println("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
    }

    private static void withdraw() {
        Account account = findAccount();
        if (account != null) {
            System.out.println("Enter PIN: ");
            int pin = scanner.nextInt();
            System.out.println("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount, pin);
        }
    }

    private static void checkBalance() {
        Account account = findAccount();
        if (account != null) {
            double balance = account.getBalance();
            System.out.println("Balance: " + balance);

        }
    }

    private static void getAccountInfo() {
        Account account = findAccount();
        System.out.println("Enter PIN: ");
        int pin = scanner.nextInt();
        account.accountInfo(pin);
    }

    // To make sure accounts do not have the same account number
    private static Object findAccount(long acctNo) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == acctNo) {
                return true;
            } else {
                return false;
            }
        }
        return null;
    }

    private static Account findAccount() {
        System.out.println("Enter Account Number: ");
        long acctNo = scanner.nextLong();
        for (Account account : accounts) {
            if (account.getAccountNumber() == acctNo) {
                System.out.println("Account Found!");
                return account;
            } else {
                System.out.println("Account Not Found!");
            }
        }
        return null;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Info.");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    getAccountInfo();
                    break;
                default:
                    break;
            }


        }


    }
}
