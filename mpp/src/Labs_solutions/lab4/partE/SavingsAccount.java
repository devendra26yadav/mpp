package Labs_solutions.lab4.partE;

public class SavingsAccount extends Account{
    private double balance;
    private double interestRate;
    private String accountID;

    public SavingsAccount( String accountID,double interestRate,double balance) {
        this.balance = balance;
        this.interestRate = interestRate;
        this.accountID = accountID;
    }

    @Override
    public String getAccountID() {
        return accountID;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double computeUpdatedBalance() {
        return balance+ (balance*interestRate);
    }
}
