package FinalExam.MockExam.prob2;

public enum Seasons
{
    SUMMER(30),FALL(15),SPRING(15),WINTER(0),;
    private final int averageTemp;

    Seasons(int temp){
        this.averageTemp=temp;
    }
    public int getAverageTemp(){
        return averageTemp;
    }
}
