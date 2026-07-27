import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.00; // Initial balance
        int choice;

        System.out.println("=== SIMPLE BANKING SYSTEM ===");

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Successfully deposited ₹" + deposit);
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdraw = scanner.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("Successfully withdrawn ₹" + withdraw);
                    } else {
                        System.out.println("Insufficient balance or invalid amount!");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using our Banking App!");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}