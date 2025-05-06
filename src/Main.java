public class Main {
    public static void main(String[] args) {

        try {
            // Create new bank accounts.
            BankAccount account;
            account = new BankAccount("24453", "Diego Saldivar", 1000);
            System.out.println("Account created successfully!");
            System.out.println(account.getAccountInfo());
            System.out.println();

            // Deposit funds into accounts, handling errors for invalid amounts.
            try {
                System.out.println("Attempting to deposit -500...");
                account.deposit(-500);
            } catch (InvalidAmountException e) {
                System.out.println("Deposit failed: " + e.getMessage());
            }

            // Withdraw funds from accounts, handling errors for insufficient funds and invalid amounts.
            try {
                System.out.println("\nAttempting to withdraw 2000...");
                account.withdraw(2000);
            } catch (InvalidAmountException | InsufficientFundsException e) {
                System.out.println("Withdrawal failed: " + e.getMessage());
            }

            // Display account balances.
            System.out.println("\nDepositing $300...");
            account.deposit(300);
            System.out.println("New Balance: $" + account.getBalance());

            System.out.println("\nWithdrawing $500...");
            account.withdraw(500);
            System.out.println("New Balance: $" + account.getBalance());

        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.err.println("Failed to create account: " + e.getMessage());
        } finally {
            System.out.println("\nThank you for using the banking system.");
        }
    }
}
