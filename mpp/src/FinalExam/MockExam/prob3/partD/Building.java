package FinalExam.MockExam.prob3.partD;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Apartment> apartments;
    public Building(List<Apartment> apartments){
        this.apartments=apartments;
    }
    public List<Apartment> getApartments(){
        return apartments;
    }
}
