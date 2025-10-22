package FinalExam.MockExam.prob3.partD;

import java.util.ArrayList;
import java.util.List;

public class Owner {
    private List<Building> buildings;
    public Owner(List<Building> buildings){
        this.buildings=buildings;
    }
    public List<Building> getBuildings(){
        return buildings;
    }
}
