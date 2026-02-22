abstract class BankAccount {
    String AccountHolder;
    String accountNumber;
    double balance;
//Constructor
    BankAccount(String AccountHolder, String accountNumber, double balance) {
        this.AccountHolder = AccountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    //deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount);
        }else{
            System.out.println("Enter valid deposit amount ");
        }
    }
    //withdraw method
    void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }else{
            System.out.println("Insufficient funds ");
        }
    }
    //display account information
    public void displayInfo(){
        System.out.println("Account Holder: " + AccountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);

    }
    //abstract method
    abstract double calculateInterest();
}
//savings account clss
class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.05;
    public SavingsAccount(String AccountHolder, String accountNumber, double balance) {
        super(AccountHolder, accountNumber, balance);
    }

    @Override
    double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}
class currentAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.05;
    public currentAccount(String AccountHolder, String accountNumber, double balance)
    {
        super(AccountHolder, accountNumber, balance);
    }

    @Override
    double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}



public class BankSystem {
    public static void main(String[] args) {
        //polymorphism in action
   BankAccount savingsAccount = new SavingsAccount("Nkotolane Pitso", "0638654343", 5000);
   BankAccount currentAccount = new currentAccount("Nkotolane Pitso", "0790504859", 50000);
//savings account
        System.out.println("--Savings Account --");
        savingsAccount.deposit(400);
        savingsAccount.withdraw(5000);
        savingsAccount.displayInfo();
        System.out.println("Monthly Interest Rate is: " + savingsAccount.calculateInterest());
        System.out.println();
        //current account
        System.out.println("--Current Account --");
        currentAccount.deposit(8000);
        currentAccount.withdraw(5000);
        currentAccount.displayInfo();
        System.out.println("Monthly Interest Rate is: " + currentAccount.calculateInterest());
    }
}
