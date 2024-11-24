package org.prog.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        List<String> aList = new ArrayList<>();
        List<String> lList = new LinkedList<>();

        //start-of-list
        lList.add("a");//start - a - "b"
        lList.add("b");// "a" - b - "e"
        //e            // "b" - e - "c"
        lList.add("c");// "e" - c - "d"
        lList.add("d");// "c" - d - end

        lList.add(2, "e");// "b" - e - "c"

        aList.add("a");//0
        aList.add("a");//1
        aList.add("a");//3
        aList.add("aashvdlsadlasld");//4
        aList.add(null);//5
        aList.add("asdohakushdsa");//6

        aList.add(2, "b");//2

//        for (int i = 0; i < aList.size(); i++) {
//            System.out.println(aList.get(i));
//        }

        for (String s : aList) {
            System.out.println(s);
        }
    }
}
