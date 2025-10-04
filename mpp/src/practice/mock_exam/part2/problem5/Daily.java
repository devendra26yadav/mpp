package practice.mock_exam.part2.problem5;

public class Daily extends Service {
    @Override
    public int calcFee() {
        return getDailyPrice() * dateDifference();
    }
}
