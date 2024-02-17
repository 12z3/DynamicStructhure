package bS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ccc {
    public static void main(String[] args) throws IOException {
        List<Integer> digit = new ArrayList<>();
        String input = "1	04 Feb 2024	16, 18, 19, 27, 37, 49	";

//        //String[] txt = input.trim().split("1\\s\\d+\\s\\w+\\s\\d+\\s");
//        String inputA = input.replaceAll("\\b\\d+\\s+\\d+\\s+\\w+\\s+\\d+\\s+", "");
//        //String inputA = input.replaceAll("1\\s04\\sJan\\s2024\\s","");
//        String[] tmpArr = inputA.trim().split(", ");
//
//        for (String s : tmpArr) digit.add(Integer.parseInt(s));
//        System.out.println(digit);
//
//        int sum = 0;
//        for (Integer el : digit) sum += el;
//        System.out.println("sum's: " + sum);
        readFile();
    }

    private static void readFile() throws IOException {
        File file = new File("/Users/blagojnikolov/Documents/VSCode/Untitled.txt");
        DateTimeFormatter formatDate =
                DateTimeFormatter.ofPattern("dd MMM yyyy, E - a- c 'ден:' HH:mm:ss ч ");
        LocalDateTime now = LocalDateTime.now();

        boolean isSaved = true;
        FileWriter writer = new FileWriter("result.txt", isSaved);
        String rowData = "";

        Scanner scanner = new Scanner(file);
        if (isSaved) writer.write(now.format(formatDate) + "\n");
        while (scanner.hasNextLine()) {
            rowData = scanner.nextLine();
            writeToFile(getString(rowData), writer, isSaved);
        }
        writer.write("\n");
        writer.close();
    }

    private static void writeToFile(String input, FileWriter writer, boolean isSaved) throws IOException {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int intgr = -111;

        String[] tmp = input.trim().split(", ");
        System.out.println(Arrays.toString(tmp));

        if (!isSaved) {
            writer.write(" ");
            return;
        }
        for (String str : tmp) {
            intgr = Integer.parseInt(str);
            res.add(intgr);
        }
        System.out.println(res);
        writer.write(res.toString());
        writer.write("\n");
    }

    private static String getString(String input) {
        String data = input.replaceAll("\\b\\d+\\s+\\d+\\s+\\w+\\s+\\d+\\s+", "");
        // return data.trim().split(", ");
        //System.out.println(data);
        return data;
    }
}
