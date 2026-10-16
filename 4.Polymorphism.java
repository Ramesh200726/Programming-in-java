import java.util.Scanner;

abstract class Payment {
    public abstract void makePayment(double amount);

    public void makePayment(double amount, String transactionId) {
        makePayment(amount);
        System.out.println("Transaction ID: " + transactionId);
    }
}

class CreditCardPayment extends Payment {
    public void makePayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Credit Card payment amount.");
        } else {
            System.out.println("Credit Card Payment Successful.");
            System.out.println("Amount Paid: Rs." + amount);
        }
    }
}

class UPIPayment extends Payment {
    public void makePayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid UPI payment amount.");
        } else {
            System.out.println("UPI Payment Successful.");
            System.out.println("Amount Paid: Rs." + amount);
        }
    }
}

class NetBankingPayment extends Payment {
    public void makePayment(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Net Banking payment amount.");
        } else {
            System.out.println("Net Banking Payment Successful.");
            System.out.println("Amount Paid: Rs." + amount);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nPAYMENT SYSTEM");
            System.out.println("1. Credit Card Payment");
            System.out.println("2. UPI Payment");
            System.out.println("3. Net Banking Payment");
            System.out.println("4. Exit");

            System.out.print("Enter payment choice: ");
            choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Thank you for using Payment System.");
                break;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid payment choice. Please try again.");
                continue;
            }

            System.out.print("Enter payment amount: ");
            double amount = sc.nextDouble();

            sc.nextLine();

            System.out.print("Enter Transaction ID: ");
            String transactionId = sc.nextLine();

            Payment payment = null;

            switch (choice) {
                case 1:
                    payment = new CreditCardPayment();
                    break;
                case 2:
                    payment = new UPIPayment();
                    break;
                case 3:
                    payment = new NetBankingPayment();
                    break;
            }

            if (transactionId.isEmpty()) {
                System.out.println("Invalid Transaction ID. Please try again.");
            } else if (amount <= 0) {
                payment.makePayment(amount);
            } else {
                payment.makePayment(amount, transactionId);
            }
        }

        sc.close();
    }
}
