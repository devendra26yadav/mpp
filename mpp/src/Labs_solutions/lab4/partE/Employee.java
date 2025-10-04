package Labs_solutions.lab4.partE;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public String name;
    private List<Account> accounts;
    public Employee(String name){
        this.name=name;
        accounts=new ArrayList<>();
    }
    public void addAccount(Account account){
        accounts.add(account);
    }
    public double computeUpdatedBalanceSum() {
        double updatedSums = 0;
        for(Account account:accounts){
            updatedSums+=account.computeUpdatedBalance();
        }
        return updatedSums;
    }
}
