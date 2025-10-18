package FinalExam.MockExam.prob3.partA;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Adam","Ibrahim","Julliane","Mike","Moe","John","Mark");
        System.out.println(startsWithTarget(names,'M'));

    }
    public static List<String> startsWithTarget(List<String> names,char target){
        return names.stream()
                .filter(name->name.startsWith(""+target))
                .sorted()
                .collect(Collectors.toList());
    }
}
