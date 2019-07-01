package lesson3;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arrStr = {"яблоко","апельсин","мандарин","груша","банан","яблоко","киви","яблоко","виноград","апельсин"};

        Set<String> arrset = new LinkedHashSet<>(Arrays.asList(arrStr));

        System.out.println(arrset);

        Map<String, Integer> arrmap = new HashMap<>();
        for (String arrstr: arrStr) {
//            Integer currentnumb = arrmap.get(arrstr);
//            arrmap.put(arrstr,currentnumb == null? 1:currentnumb+1);
            arrmap.put(arrstr,arrmap.getOrDefault(arrstr,0)+1);
        }
        System.out.println(arrmap);

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов","555-888");
        phoneBook.add("Петров","666-777");
        phoneBook.add("Сидоров","444-999");
        phoneBook.add("Петров","333-200");
        phoneBook.add("Иванов","555-100");

        System.out.println(phoneBook.get("Петров"));
        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Sidorov"));

    }
}
