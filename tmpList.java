package dynamicsStructhure;

import java.util.*;

public class tmpList {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> b = new ArrayList<>(List.of(4, 5, 6));
        List<Integer> c = new ArrayList<>(List.of(7, 8, 9));
        List<List<Integer>> tmp = new ArrayList<>(List.of(a, b, c));

        List<Integer> x = new ArrayList<>(List.of(7, 8, 3));
        List<Integer> d = new ArrayList<>();

        checkMatches(tmp,x);

//        for (int k = 0; k < x.size(); k++) {
//            int el1 = x.get(k);
//            for (int i = 0; i < tmp.size(); i++) {
//                for (int j = 0; j < tmp.get(i).size(); j++) {
//                    int el2 = tmp.get(i).get(j);
//                    if (Objects.equals(x.get(k), tmp.get(i).get(j))) {
//                        d.add(tmp.get(i).get(j));
//                    }
//                }
//            }
//        }
//            System.out.println(Arrays.toString(d.toArray()));
    }

    private static void checkMatches(List<List<Integer>> res, List<Integer> arr) {
        List<List<Integer>> matches = new ArrayList<>();
        List<Integer> tmp = null;
        int idx = 1;
        int cnt = 0;
        boolean isBreak = false;

        for (int i = 0; i < arr.size(); i++) {
            tmp = new ArrayList<>();
            cnt = 0;
            for (int j = 0; j < res.size(); j++) {
                isBreak = false;
                for (int k = 0; k < res.get(j).size(); k++) {
                    if (Objects.equals(arr.get(i), res.get(j).get(k))) {
                        tmp.add(res.get(j).get(k));
                        cnt++;
                        isBreak = true;
                        idx = ++j;
                        break;
                    }
                }
                if (isBreak) break;
            }
            matches.add(tmp);
        }
        System.out.println(matches  + " on idx: " + idx);
        System.out.println();
//        for (int i = 0; i < matches.size(); i++) {
//            System.out.print(" " + matches.get(i));
//        }
    }
}
