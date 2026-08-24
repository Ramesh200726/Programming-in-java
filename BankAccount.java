import java.util.Scanner;

class BankAccount {
    String accountHolderName;
    long accountNumber;
    String accountType;
    double accountBalance;

    BankAccount(String name, long accNo, String type, double balance) {
        accountHolderName = name;
        accountNumber = accNo;
        accountType = type;
        accountBalance = balance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount: " + amount);
        } else {
            accountBalance += amount;
            System.out.println("Deposited: " + amount + " | Updated Balance: " + accountBalance);
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount: " + amount);
        } else if (amount > accountBalance) {
            System.out.println("Insufficient Balance");
        } else {
            accountBalance -= amount;
            System.out.println("Withdrawn: " + amount + " | Remaining Balance: " + accountBalance);
        }
    }

    void balanceEnquiry() {
        System.out.println("Account Details -> Name: " + accountHolderName + ", Acc No: " + accountNumber + ", Type: " + accountType + ", Balance: " + accountBalance);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        long accNo = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Account Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        BankAccount account = new BankAccount(name, accNo, type, balance);

        int choice;
        do {
            System.out.println("\n--- Banking Operations Menu ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dAmount = scanner.nextDouble();
                    account.deposit(dAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wAmount = scanner.nextDouble();
                    account.withdraw(wAmount);
                    break;
                case 3:
                    account.balanceEnquiry();
                    break;
                case 4:
                    System.out.println("Exiting Banking Application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
