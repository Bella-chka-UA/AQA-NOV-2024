package org.prog.collections;

import java.util.HashMap;
import java.util.Map;

public class MapsDemo {

    public static void main(String[] args) {
        Map<String, String> sMap = new HashMap<>();
        Map<String, String> sMap2 = new HashMap<>();

        sMap.put("key_1", "value_1");
        sMap.putIfAbsent("key_1", "overwrite_value");
        sMap.put("key_3", null);
        sMap.put(null, "value_null");

        sMap2.put("key_4", " value_4");
        sMap2.put("key_5", " value_5");

        sMap.putAll(sMap2);
        sMap.size();
    }

    public static void printValueLength(Map<String, String> someMap, String key) {
        if (someMap.containsKey(key)) {
            System.out.println(someMap.get(key).length());
        } else {
            System.out.println("Key not found: " + key);
        }
    }
}
