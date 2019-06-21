package lesson3;


import java.util.*;

public class PhoneBook {
    private Map<String, LinkedList<String>> map = new HashMap<>();

    public PhoneBook() {
        this.map = map;
    }

    public void add(String fam, String num) {
        LinkedList<String> numb = new LinkedList<>();
        if (map.containsKey(fam)) {
            numb = map.get(fam);
        }

        numb.add(num);
        map.put(fam, numb);
    }

    public LinkedList<String> get(String fam) {
        System.out.print(fam + ": ");
        return map.get(fam);
    }

}
