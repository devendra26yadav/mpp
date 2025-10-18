package FinalExam.MockExam.prob3.partD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Apartment> apts1 = Arrays.asList(new Apartment(100),new Apartment(200),new Apartment(300));
        List<Apartment> apts2 = Arrays.asList(new Apartment(500),new Apartment(300),new Apartment(100));
        List<Apartment> apts3 = Arrays.asList(new Apartment(400),new Apartment(100),new Apartment(500));

        List<Building> bldg1 = Arrays.asList(new Building(apts1),new Building(apts2));
        List<Building> bldg2 = Arrays.asList(new Building(apts3));
        Owner owner1 = new Owner(bldg1);
        Owner owner2 = new Owner(bldg2);
        List<Owner> ownerList = new ArrayList<>();
        ownerList.add(owner1);
        ownerList.add(owner2);


    }
//    public static double allOwnerTotalApartmentRent(List<Owner> owners){
//        return
//    }
}
