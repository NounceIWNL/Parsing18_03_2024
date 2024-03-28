import java.util.*;


public class CollectionPractice {
    public static void main(String[] args) {

        SortedMap<String, Integer> list1 = new TreeMap<>();
        list1.put("Year", 1990);
        SortedMap<String, Integer> list2 = new TreeMap<>();
        list2.put("Year", 1992);
        SortedMap<String, Integer> list3 = new TreeMap<>();
        list3.put("Year", 1995);
        SortedMap<String, Integer> list4 = new TreeMap<>();
        list4.put("Year", 1987);
        SortedMap<String, Integer> list5 = new TreeMap<>();
        list5.put("Year", 1984);
        SortedMap<String, Integer> list6 = new TreeMap<>();
        list6.put("Year", 1988);

        List<String> lists = new ArrayList<>();
        lists.add(String.valueOf(list1));
        lists.add(String.valueOf(list2));
        lists.add(String.valueOf(list3));
        lists.add(String.valueOf(list4));
        lists.add(String.valueOf(list5));
        lists.add(String.valueOf(list6));

        Collections.sort(lists);



        System.out.println(lists);


    }
}

