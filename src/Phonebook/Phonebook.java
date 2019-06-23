package Phonebook;

import java.util.*;

 class PhoneBook {
    private Map<String, LinkedList<String>> pb = new HashMap<>();

    public PhoneBook() {
        this.pb = pb;
    }

    public void add(String fam, String num) {
        LinkedList<String> numb = new LinkedList<>();
        if (pb.containsKey(fam)) {
            numb = pb.get(fam);
        }
        numb.add(num);
        pb.put(fam, numb);
    }


    public LinkedList<String> get(String fam) {
        System.out.print(fam + ": ");
        return pb.get(fam);
    }

}