package FinalExam.MockExam.prob4.partB;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class ImpToStreams {
    static Long ItemCount=0L;
    static List<String> TractList = new ArrayList<>();

    public static Long calcUniqueItems(List<Item> items){
        for(Item i:items){
            if(TractList.contains(i.getName())){

            }
            else{
                TractList.add(i.getName());
                ItemCount++;
            }
        }
        return ItemCount;
    }
    public static long calcUniqueItemsStream(List<Item> items){
        return items.stream()
                .map(Item::getName)
                .distinct()
                .count();
    }

    public static void main(String[] args) {
        List<Item> items = List.of(new Item("A"),new Item("B"),new Item("C"),new Item("D"),new Item("C"),new Item("B"));
        System.out.println("By using Imperative Style : "+calcUniqueItems(items));
        System.out.println("By Using Declarative Style : "+calcUniqueItemsStream(items));
    }
}
