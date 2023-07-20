/*      Map
- It is a interface. Can be created from "HashMap" or "TreeMap" class.
    - TreeMap applies binary search data structure and map. In case of string it store data in alphabetical order.

- It store key-value pair. Like python's dictionary.
    Key are always unique.

- HashMap show properties of hash and map.

*/ 

import java.util.Map;
import java.util.HashMap;

public class L7_Map {
    public static void main(String[] args) {
        
        Map<String, Integer> map = new HashMap<>();

        // "put" for insertion
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        System.out.println(map);

        // "putIfAbsent" only insert if given key does'nt exist in map.
        map.putIfAbsent("Three", 333); 



        // for iteration
        for (Map.Entry<String, Integer> e: map.entrySet()){
            System.out.println(e);
        }
        
        System.out.println("**************************");

        for(Map.Entry<String,Integer> e: map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        System.out.println("****************************");

        
        for (String key: map.keySet()){ // map.keySet give set of key.
            System.out.println(key);
        }

        for (Integer value: map.values()){ // map.values give set of values
            System.out.println(value);
        }

        System.out.println(map.values());


        System.out.println(map.containsKey("One"));
        System.out.println(map.containsValue(1));


        System.out.println(map.isEmpty());



    }
}
