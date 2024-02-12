import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getData {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/blagojnikolov/Documents/VSCode/tmpA.txt");

        System.out.println();
        List<List<Integer>> listOfInt = dataToInteger(readFromFile(file));
        System.out.println(checkIntegers(listOfInt));
        System.out.println();

    }

    private static String readFromFile(File file) throws IOException {
        String data = " ";
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            data = scanner.nextLine();
        }
        System.out.println(data);
        return data;
    }

    private static List<List<Integer>> dataToInteger(String rowData) {
        List<List<Integer>> listOfInt = new ArrayList<>();
        List<String> listOfStrings = new ArrayList<>();

        String StrinG = getString(rowData);
        listOfStrings = getSubString(StrinG);

        for (String el : listOfStrings) {
            List<Integer> tmp = new ArrayList<>();
            String[] arr = el.trim().split(", ");
            for (String elArr : arr) {
                tmp.add(Integer.parseInt(elArr));
            }
            listOfInt.add(tmp);
        }
        for (List<Integer> el : listOfInt)
            System.out.println(el); // ! <-
        return listOfInt;
    }

    private static String getString(String rowData) {
        int fromIdx = rowData.indexOf('[');
        int toIdx = rowData.lastIndexOf(']');
        String StrinG = rowData.substring(fromIdx + 1, toIdx);
        return StrinG;
    }

    private static List<String> getSubString(String rowData) {
        List<String> listOfStrings = new ArrayList<>();
        int fromIdx = rowData.indexOf("[");
        int toIdx = rowData.indexOf("]");
        int cnt = 0;
        while (cnt < 3) {
            String tmpSubString = rowData.substring(fromIdx + 1, toIdx);
            listOfStrings.add(tmpSubString);

            fromIdx = rowData.indexOf("[", toIdx);
            toIdx = rowData.indexOf("]", fromIdx);
            cnt++;
        }
        return listOfStrings;
    }

    private static List<Integer> checkIntegers(List<List<Integer>> list) {
        List<Integer> sumOfRowsNum = new ArrayList<>();
        int sum;
        for (int i = 0; i < list.size(); i++) {
            sum = 0;
            for (int j = 0; j < list.get(i).size(); j++) {
                sum += list.get(i).get(j);
            }
            sumOfRowsNum.add(sum);
        }
        return sumOfRowsNum;
    }
}
