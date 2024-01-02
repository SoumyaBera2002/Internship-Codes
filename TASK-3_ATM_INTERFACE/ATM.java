import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
            return true;
        }
    }
}

public class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                checkBalance();
                break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        withdraw(withdrawalAmount);
                        break;
                        case 4:
                            System.out.println("Exiting. Thank you!");
                            break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + bankAccount.getBalance());
    }

    private void deposit(double amount) {
        bankAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: " + bankAccount.getBalance());
    }

    private void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            atm.displayOptions();
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            if (choice != 4) {
                atm.performTransaction(choice);
            }

        } while (choice != 4);

        scanner.close();
    }
}
