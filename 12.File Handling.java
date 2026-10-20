import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class LibraryTransaction {
    String bookId;
    String bookName;
    String studentName;
    String issueDate;
    String returnDate;

    public LibraryTransaction(String bookId, String bookName,
                              String studentName, String issueDate,
                              String returnDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentName = studentName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public String toString() {
        return "Book ID: " + bookId
                + ", Book Name: " + bookName
                + ", Student: " + studentName
                + ", Issue Date: " + issueDate
                + ", Return Date: " + returnDate;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "transactions.txt";
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Record Book Transaction");
            System.out.println("2. View Transaction Records");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            String inputChoice = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(inputChoice);
            } catch (NumberFormatException e) {
                choice = -1;
            }

            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                String bookId = scanner.nextLine();

                System.out.print("Enter Book Name: ");
                String bookName = scanner.nextLine();

                System.out.print("Enter Student/User Name: ");
                String studentName = scanner.nextLine();

                System.out.print("Enter Issue Date: ");
                String issueDate = scanner.nextLine();

                System.out.print("Enter Return Date: ");
                String returnDate = scanner.nextLine();

                LibraryTransaction transaction =
                        new LibraryTransaction(
                                bookId, bookName, studentName,
                                issueDate, returnDate);

                try {
                    FileWriter writer =
                            new FileWriter(fileName, true);

                    writer.write(transaction.toString() + "\n");
                    writer.close();

                    System.out.println(
                            "Transaction recorded successfully.");
                } catch (IOException e) {
                    System.out.println(
                            "Error accessing the file: "
                                    + e.getMessage());
                }

            } else if (choice == 2) {
                File file = new File(fileName);

                if (file.exists() && file.length() > 0) {
                    try {
                        FileReader reader = new FileReader(file);

                        System.out.println(
                                "\n--- Transaction Records ---");

                        int character;
                        while ((character = reader.read()) != -1) {
                            System.out.print((char) character);
                        }

                        System.out.println(
                                "\n---------------------------");
                        reader.close();

                    } catch (IOException e) {
                        System.out.println(
                                "Error reading the file: "
                                        + e.getMessage());
                    }
                } else {
                    System.out.println("No transaction records found.");
                }

            } else if (choice == 3) {
                System.out.println(
                        "Exiting Library Management System.");
                exit = true;

            } else {
                System.out.println(
                        "Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}
