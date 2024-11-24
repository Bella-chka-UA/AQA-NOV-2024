package org.prog.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> strings = new HashSet<>(); //Map<String, String> map = new HashMap...
        strings.add("a");//map.add("a","a");
        strings.add("a");//map.add("a","a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");
        System.out.println(strings.size());

//        for (String s : strings) {
//            System.out.println(s);
//        }

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
