package dynamicsStructure;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class duplicate {
    public static void main(String[] args) {
        Map<Integer, Integer> idxValue = new TreeMap<>();
        Map<Integer, Integer> idxTmp = new TreeMap<>();
        Set<Integer> res = new HashSet<>();

        int[] a = {1, 1, 2, 3, 4, 2, 3, 1, 9, 4};

        for (int i = 0; i < a.length; i++) {
            if (idxValue.containsValue(a[i])) {
                idxTmp.put(i, a[i]);
            } else idxValue.put(i, a[i]);
        }

        System.out.print("unique ->     ");
        for (Map.Entry<Integer, Integer> el : idxValue.entrySet()) {
            System.out.printf("%d:%d ", el.getKey(), el.getValue());
        }
        System.out.println();
        System.out.print("duplicated -> ");
        for (Map.Entry<Integer, Integer> el : idxTmp.entrySet()) {
            System.out.printf("%d:%d ", el.getKey(), el.getValue());
        }

    }
}
