import java.util.Scanner;

public class ATM {
    private static double balance = 1000.0; // Initial balance
    private static String correctPin = "1234"; // Correct PIN for authentication

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3; // Number of attempts before locking the user out

        System.out.println("Welcome to the ATM");
        System.out.print("Please enter your PIN: ");
        
        // Validate PIN
        while (attempts > 0) {
            String pin = scanner.nextLine();
            
            if (pin.equals(correctPin)) {
                System.out.println("PIN verified successfully.");
                displayMenu(scanner);
                break;
            } else {
                attempts--;
                if (attempts == 0) {
                    System.out.println("Incorrect PIN. Your account has been locked.");
                    break;
                } else {
                    System.out.println("Incorrect PIN. You have " + attempts + " attempt(s) left.");
                    System.out.print("Please enter your PIN: ");
                }
            }
        }
    }

    private static void displayMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        double depositAmount = scanner.nextDouble();
        
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("$" + depositAmount + " has been deposited. Your new balance is: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");
        double withdrawAmount = scanner.nextDouble();
        
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("$" + withdrawAmount + " has been withdrawn. Your new balance is: $" + balance);
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient balance for the withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}