package Labs_solutions.lab4.partE;

import java.util.List;

public class Admin {
    public static double computeUpdatedBalanceSum(List<Employee> list) {
        double updatedBalance =0;
        if(list==null) return 0;
        for(Employee e:list){
            updatedBalance+=e.computeUpdatedBalanceSum();
        }
        return updatedBalance;
    }
}