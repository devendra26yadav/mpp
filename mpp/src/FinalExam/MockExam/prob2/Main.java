package FinalExam.MockExam.prob2;

public class Main {
    public static void main(String[] args) {
        for(Seasons s:Seasons.values()){
            System.out.println(s+ " average temperature "+s.getAverageTemp()+ "°C");
            System.out.println(s.ordinal());
        }
        System.out.println(Seasons.SUMMER);

    }
}
