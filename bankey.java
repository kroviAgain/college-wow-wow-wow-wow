import java.util.Scanner;

class Account {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal or insufficient balance!");
        }
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("--------------------------");
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

public class bank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Account[] accounts = new Account[10];
        int accountCount = 0;

        while (true) {
            System.out.println("\n===== Bank Menu =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            if (choice == 1) {
                if (accountCount < accounts.length) {
                    System.out.print("Enter Account Number: ");
                    int accNo = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = scan.nextDouble();

                    accounts[accountCount] = new Account(accNo, name, bal);
                    accountCount++;
                    System.out.println("  Account Created Successfully!");
                } else {
                    System.out.println("Bank limit reached. Cannot create more accounts.");
                }

            } else if (choice == 2) {
                System.out.print("Enter Account Number: ");
                int tempnumber = scan.nextInt();
                boolean found = false;
                for (int i = 0; i < accountCount; i++) {
                    if (accounts[i].getAccountNumber() == tempnumber) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = scan.nextDouble();
                        accounts[i].deposit(amt);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("  Account not found!");

            } else if (choice == 3) {
                System.out.print("Enter Account Number: ");
                int tempnumber = scan.nextInt();
                boolean found = false;
                for (int i = 0; i < accountCount; i++) {
                    if (accounts[i].getAccountNumber() == tempnumber) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = scan.nextDouble();
                        accounts[i].withdraw(amt);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("  Account not found!");

            } else if (choice == 4) {
                System.out.print("Enter Account Number: ");
                int tempnumber = scan.nextInt();
                boolean found = false;
                for (int i = 0; i < accountCount; i++) {
                    if (accounts[i].getAccountNumber() == tempnumber) {
                        accounts[i].display();
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Account not found!");

            } else if (choice == 5) {
                if (accountCount == 0) {
                    System.out.println("No accounts available.");
                } else {
                    for (int i = 0; i < accountCount; i++) {
                        accounts[i].display();
                    }
                }

            } else if (choice == 6) {
                System.out.println("Thank you for using the Bank System. Goodbye!");
                scan.close();
                System.exit(0);

            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
