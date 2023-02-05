public class BankAccount {
    private int balance;

    public void deposit(int amount) {
        balance += amount;
    }

    public static void main(String[] args) {
        BankAccount checkingAccount = new BankAccount();
        BankAccount savingsAccount = new BankAccount();
        //add code to deposit money in each account

    }
}