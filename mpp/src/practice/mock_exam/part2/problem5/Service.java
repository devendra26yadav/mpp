package practice.mock_exam.part2.problem5;
import java.time.LocalDate;
import java.time.Period;

public abstract class Service {
    private int Daily_Price;
    private LocalDate Date_Subscribed;

    public void setDailyPrice(int dailyPrice) {
        this.Daily_Price = dailyPrice;
    }

    public int getDailyPrice() {
        return this.Daily_Price;
    }

    public void setDateSubscribed(LocalDate dateSubscribed) {
        this.Date_Subscribed = dateSubscribed;
    }

    public LocalDate getDateSubscribed() {
        return this.Date_Subscribed;
    }

    public int dateDifference() {
        LocalDate now = LocalDate.now();
        LocalDate subDate = Date_Subscribed;
        Period period = Period.between(subDate, now);

        int monthDiff = period.getMonths();
        int dayDiff = period.getDays();
        int diff;

        if (monthDiff != 0)
            diff = (monthDiff * 30) + dayDiff;
        else
            diff = dayDiff;

        return diff;
    }

    public abstract int calcFee();
}
