package DynamicsStructhure;

import training.Methods;

import java.util.HashMap;
import java.util.Map;

public class MapTest extends Methods {
    public static void main(String[] args) {

        String one = "a;shf#@#12313asdgfsdf";
        String two = "12345";
        int[] a = {0, 11, 2, 33, 0, 5};


        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapI = new HashMap<>();
        map.put("A", 12);
        map.put("B", 32);
        map.put("C", 22);

        mapI.put(1,1);
        mapI.put(2,2);
        mapI.put(3,3);
        mapI.put(4,4);
        mapI.put(5,5);

//        if (map.containsKey("C")){
//            System.out.println(map.get("C"));
//        }
//
//        System.out.println("map = " + map);
//
//        for (String key: map.keySet()){
//            System.out.print(" " + key);
//        }
//        System.out.println();
//        for (Integer val: map.values()){
//            System.out.print(" " + val);
//        }

        System.out.println(mapI.get(1));
        for (Integer key: mapI.keySet()) System.out.print(key + " ");
        System.out.println();
        for (Integer val: mapI.values()) System.out.print(val + " ");
        System.out.println();
        System.out.println(mapI.get(1));


    }
}
