package Labs_solutions.lab4.partE;

public class CheckingAccount extends Account{
    private double balance;
    private double monthlyFee;
    private String accountID;

    public CheckingAccount( String accountID,double monthlyFee, double balance) {
        this.balance = balance;
        this.monthlyFee = monthlyFee;
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
        return balance-monthlyFee;
    }
}
