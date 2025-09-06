import java.util.Scanner;

class Acc {
    int accNo;
    String holder;
    double bal;
    String mail;
    String phone;

    Acc(int a, String h, double b, String m, String p) {
        accNo = a;
        holder = h;
        bal = b;
        mail = m;
        phone = p;
    }

    void deposit(double amt) {
        if (amt > 0) {
            bal = bal + amt;
            System.out.println("Deposited: " + amt);
        } else {
            System.out.println("Deposit must be positive!");
        }
    }

    void withdraw(double amt) {
        if (amt > 0 && bal >= amt) {
            bal = bal - amt;
            System.out.println("Withdrawn: " + amt);
        } else {
            System.out.println("Not possible to withdraw that amount!");
        }
    }

    void show() {
        System.out.println("\n-- Account Info --");
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + holder);
        System.out.println("Balance: " + bal);
        System.out.println("Email: " + mail);
        System.out.println("Phone: " + phone);
    }

    void update(String newMail, String newPhone) {
        mail = newMail;
        phone = newPhone;
        System.out.println("Contact updated.");
    }
}

class UI {
    Acc[] list;
    int count;
    int nextNo = 1001;
    Scanner in = new Scanner(System.in);

    UI(int size) {
        list = new Acc[size];
        count = 0;
    }

    Acc find(int no) {
        for (int i = 0; i < count; i++) {
            if (list[i].accNo == no) {
                return list[i];
            }
        }
        return null;
    }

    void makeAcc() {
        int no = nextNo++;
        in.nextLine(); // clear buffer
        System.out.print("Enter name: ");
        String name = in.nextLine();
        System.out.print("Enter opening balance: ");
        double b = in.nextDouble();
        in.nextLine();
        System.out.print("Enter email: ");
        String mail = in.nextLine();
        System.out.print("Enter phone: ");
        String ph = in.nextLine();

        list[count++] = new Acc(no, name, b, mail, ph);
        System.out.println("Account made! Your acc no is " + no);
    }

    void doDeposit() {
        System.out.print("Enter acc no: ");
        int no = in.nextInt();
        System.out.print("Enter deposit amt: ");
        double amt = in.nextDouble();
        Acc a = find(no);
        if (a != null) a.deposit(amt);
        else System.out.println("Acc not found!");
    }

    void doWithdraw() {
        System.out.print("Enter acc no: ");
        int no = in.nextInt();
        System.out.print("Enter withdraw amt: ");
        double amt = in.nextDouble();
        Acc a = find(no);
        if (a != null) a.withdraw(amt);
        else System.out.println("Acc not found!");
    }

    void showAcc() {
        System.out.print("Enter acc no: ");
        int no = in.nextInt();
        Acc a = find(no);
        if (a != null) a.show();
        else System.out.println("Acc not found!");
    }

    void changeContact() {
        System.out.print("Enter acc no: ");
        int no = in.nextInt();
        in.nextLine();
        Acc a = find(no);
        if (a != null) {
            System.out.print("New email: ");
            String m = in.nextLine();
            System.out.print("New phone: ");
            String p = in.nextLine();
            a.update(m, p);
        } else {
            System.out.println("Acc not found!");
        }
    }

    void menu() {
        while (true) {
            System.out.println("\n*** Banking Menu ***");
            System.out.println("1. New account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show account");
            System.out.println("5. Update contact");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int ch = in.nextInt();

            switch (ch) {
                case 1: makeAcc(); break;
                case 2: doDeposit(); break;
                case 3: doWithdraw(); break;
                case 4: showAcc(); break;
                case 5: changeContact(); break;
                case 6: 
                    System.out.println("Bye bye!");
                    return;
                default: 
                    System.out.println("Wrong choice!");
            }
        }
    }
}

public class BankApp {
    public static void main(String[] args) {
        UI ui = new UI(100);
        System.out.println("Welcome to Bank App!");
        ui.menu();
    }
}
