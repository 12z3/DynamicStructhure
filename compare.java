package dynamicsStructure.Jackpot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class compare {
    public static void main(String[] args) {

        int[][] c = {{4, 11, 12, 25, 39, 49}, {23, 24, 26, 34, 35, 36}, {7, 18, 19, 29, 38, 41}};
        List<List<Integer>> a = new ArrayList<>(List.of((
                List.of(4, 11, 12, 25, 39, 49)),
                List.of(23, 24, 26, 34, 35, 36),
                List.of(7, 18, 19, 29, 38, 41)));
        List<Integer> b = new ArrayList<>(List.of(4, 11, 12, 25, 35, 41));
        Set<Integer> tmp = new HashSet<>(b);

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (b.contains(a.get(i).get(j))) System.out.print(a.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
