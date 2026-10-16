import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Account {
    String accountHolderName;
    double accountBalance;

    public Account(String name, double balance) {
        accountHolderName = name;
        accountBalance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: " + accountBalance);
    }

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Invalid Withdrawal Amount");
        }

        if (amount > accountBalance) {
            throw new InsufficientBalanceException(
                "Insufficient balance");
        }

        accountBalance -= amount;

        System.out.println("Withdrawal Successful");
        System.out.println(
            "Remaining Account Balance: " + accountBalance);
    }
}

public class ATM {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter Account Holder Name:");
            String name = in.nextLine();

            System.out.println("Enter Initial Account Balance:");
            double balance = in.nextDouble();

            Account acc = new Account(name, balance);

            acc.displayDetails();

            System.out.println("Enter Number of Withdrawals:");
            int n = in.nextInt();

            for (int i = 1; i <= n; i++) {

                System.out.print(
                    i + ". Enter Withdrawal Amount: ");

                double amount = in.nextDouble();

                try {
                    acc.withdraw(amount);

                } catch (InsufficientBalanceException |
                         IllegalArgumentException e) {

                    System.out.println(
                        "Transaction Failed! " + e.getMessage());

                    System.out.println(
                        "Remaining Account Balance: "
                        + acc.accountBalance);
                }
            }

            Account nullAccount = null;

            try {
                nullAccount.withdraw(1000);

            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());

            } catch (NullPointerException e) {
                System.out.println("Account object is null");
            }

        } catch (InputMismatchException e) {

            System.out.println(
                "Invalid Input: Enter only Numeric Values");

        } finally {
            in.close();
        }
    }
}
