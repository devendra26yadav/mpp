package FinalExam.wildcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test1 {
    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>();
       // list.add(10.90);//java: incompatible types: double cannot be converted to capture#1 of ? extends java.lang.Number

        Number n = list.get(0);
    }

}
