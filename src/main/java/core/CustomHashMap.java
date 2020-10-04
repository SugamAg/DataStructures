package core;

import java.util.*;

/**
 * @author sugamagarwal
 */
public class CustomHashMap<K, V> {

    Map<K, V> map;
    Queue<K> hashList;

    public CustomHashMap(int size) {
        this.map = new HashMap<>(size);
        this.hashList = new LinkedList<>();
    }

    void put(K key, V value) {
         map.put(key, value);
         hashList.add(key);
    }

    V get(K key) {
       return map.get(key);
    }


    // Input - {12,16, 3,9,89,7,23,54}
    //Output - 9897543231612
   static void largestPossibleNum(int[] ar) {
        List<String> list = new ArrayList<>();
        for(int i: ar) {
            list.add(String.valueOf(i));
        }
        Collections.sort(list);
        Collections.reverse(list);
        String join = String.join("", list);
        System.out.println(join);
    }



    public static void main(String[] args) {
        CustomHashMap<String, String> map = new CustomHashMap<>(5);
        map.put("A", "Heyy");
        map.put("B", "Heyy1");
        map.put("C", "Heyy2");
        map.put("D", "Heyy3");
        map.put("E", "Heyy4");
    }

}
