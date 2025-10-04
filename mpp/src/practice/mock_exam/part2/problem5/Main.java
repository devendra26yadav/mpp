package practice.mock_exam.part2.problem5;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Dev", 101);

        Monthly monthlyService = new Monthly();
        monthlyService.setDailyPrice(10);
        monthlyService.setDateSubscribed(LocalDate.of(2024, 3, 8));

        Daily dailyService = new Daily();
        dailyService.setDailyPrice(5);
        dailyService.setDateSubscribed(LocalDate.of(2023, 9, 8));

        customer.addService(monthlyService);
        customer.addService(dailyService);

        System.out.println("Total Fee: " + customer.totalFee());
    }
}
