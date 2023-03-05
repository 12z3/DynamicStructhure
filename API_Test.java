package dynamicsStructhure.API;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class API_Test {
    public static void main(String[] args) {
        List<Integer> listInt = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Double> listDb = new ArrayList<>(List.of(1., 2., 3., 4., 5., 6., 7., 8., 9.));
        List<String> listStr = new ArrayList<>(List.of("as", "dslkd", "dwe", "poi", "jkl"));

        List<Integer> collect = listInt.stream()
                .filter(x -> x > 3 && x < 9)
                .map(x -> x * 2)
                .sorted()
                .toList();

        DoubleSummaryStatistics doubleSummaryStatistics = listInt.stream().mapToDouble(x -> x).summaryStatistics();

        collect.forEach(System.out::print);
        System.out.println();
        for (Integer el : collect) System.out.print(el + " ");

        System.out.println("\n" + doubleSummaryStatistics);

    }
}
