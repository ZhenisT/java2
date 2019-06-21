package lesson3;

import java.util.*;

public class PhoneBook {
    private Map<String, LinkedList<String>> map;

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    public void add(String fam, String num) {
        LinkedList<String> numb;
        if (map.containsKey(fam)) {
            numb = map.get(fam);
        }
        numb = new LinkedList<>();
        numb.add(num);
        map.put(fam, numb);
    }


    public LinkedList<String> get(String fam) {
        System.out.print(fam + ": ");
        return map.get(fam);
    }

}