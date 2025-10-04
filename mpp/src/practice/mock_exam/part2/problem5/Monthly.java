package practice.mock_exam.part2.problem5;

public class Monthly extends Service {
    @Override
    public int calcFee() {
        return getDailyPrice() * 30;
    }
}
