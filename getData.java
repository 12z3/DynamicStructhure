
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getData extends findMethods {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/blagojnikolov/Desktop/@tmp/reportDSK.csv");

        List<String[]> resToArr = read(file);
        // printOneLine(resToArr, 4);

        printDealers(file);

        System.out.println();
        for (int row = 0; row < resToArr.size(); row++) {
            if (!getMoneyToStr(resToArr.get(row), "\\d{2,3} \\d{2} BGN")
                    .equalsIgnoreCase("No such matches")) {
                System.out.println(
                        resToArr.get(row)[3].trim() + ": "
                                + getMoneyToStr(resToArr.get(row), "\\d{2,3} \\d{2} BGN"));
            }
        }

        for (Map.Entry<Integer, String> el : findInLine(resToArr, "ЕВН ЕЛ. ЕНЕРГИЯ -ЕЛ.КАНАЛИ").entrySet())
            System.out.println(el.getKey() + " - " + el.getValue());

        allSpendMoneyA(file);

    }

    protected static void printDealers(File file) throws FileNotFoundException {
        System.out.println();
        String vivacom = "VIVACOM АБОНАМЕНТЕН ПЛАН";
        String electrohold = "ЕЛЕКТРОХОЛД ПРОДАЖБИ АД";
        String evn = "ЕВН ЕЛ. ЕНЕРГИЯ - ЕЛ.КАНАЛИ";
        String netsurf = "НЕТ - СЪРФ.НЕТ";
        String chez = "ЧЕЗ";
        String date = "15.04.2022";

        System.out.print("-----------------------------------");
        find(file, electrohold);
        findMoneyFromDealer(file, electrohold);
        find(file, vivacom);
        findMoneyFromDealer(file, vivacom);
        find(file, evn);
        findMoneyFromDealer(file, evn);
        find(file, netsurf);
        findMoneyFromDealer(file, netsurf);
        System.out.println("-----------------------------------");
        System.out.printf("All spend sum: %.2fBGN%n", allSpendMoney(file));
        System.out.println("-----------------------------------");

    }

    protected static void printOneLine(List<String[]> line, int lineNumber) {
        System.out.println();
        for (int string = 0; string < line.get(lineNumber).length; string++) {
            System.out.print(line.get(lineNumber)[string] + " ");
        }
        System.out.println();
    }

    protected static void print(List<String[]> readFromFile, String dealer) {
        Map<Integer, String> result = findInLine(readFromFile, dealer);
        for (Map.Entry<Integer, String> el : result.entrySet())
            System.out.println("row: " + el.getKey() + " - " + el.getValue() + " ");
    }

    // ! Търси колко пъти "some" се среща във всеки ред(Масив от Str) в листа "line"
    // * Виждаш какво връща метода */
    protected static Map<Integer, String> findInLine(List<String[]> line, String some) {
        some.trim();
        System.out.println();
        int lineNumber = -1, cnt;

        Map<Integer, String> result = new HashMap<>();
        for (int row = 0; row < line.size(); row++) {
            cnt = 0;
            for (int string = 0; string < line.get(row).length; string++) {
                String thisLine = line.get(row)[string].trim();
                if (some.equalsIgnoreCase(thisLine)) {
                    lineNumber = row;
                    result.put(lineNumber, some);
                    cnt++;

                }
            }
        }
        // System.out.println();
        return result;
    }

    // ! Връща List. Всеки един ред от List е масив от Str:
    protected static List<String[]> read(File file) throws FileNotFoundException {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(file);
        List<String[]> readList = new ArrayList<>();
        List<String> oneLine;
        String[] line = null;

        while (scanner.hasNext()) {
            oneLine = new ArrayList<>();
            line = scanner.nextLine()
                    .replaceAll("[\"']", "").trim().split(",");
            readList.add(line);
        }
        return readList;
    }

    protected static String findDate(String input) {
        String dateRgx = "\\d{2}\\.\\d{2}\\.\\d{4}";

        Pattern datePattern = Pattern.compile(dateRgx);
        Matcher dateMatcher = datePattern.matcher(input);
        if (dateMatcher.find()) {
            return dateMatcher.group();
        } else
            return "No such matches";
    }

    // ! Стринга "109 78 BGN" се форматира в "109 78 BGN"
    protected static String formatMoney(String[] input) {
        StringBuilder stb = new StringBuilder();
        stb.append(input[5]);
        stb.append(" ");
        stb.append(input[6]);
        return stb.toString();
    }

    // ! Намира всяко едно съвпадение на "109 37 BGN" за даден ред.
    // * Връща "109.37 BGN" */
    protected static String getMoneyToStr(String[] input, String some) {
        Pattern datePattern = Pattern.compile(some);
        // * За всеки един ред от масива търси съвпадението - (109 37 BGN) */
        for (int i = 0; i < input.length; i++) {
            Matcher dateMatcher = datePattern.matcher(formatMoney(input));
            if (dateMatcher.find()) {
                StringBuilder stb = new StringBuilder();
                // return dateMatcher.group();
                stb.append(input[5]);
                stb.append(".");
                stb.append(input[6]);
                return stb.toString();
            }
        }
        return "No such matches";
    }

    protected static Double allSpendMoney(File file) throws FileNotFoundException {
        List<String> tmp = new ArrayList<>();
        List<String[]> input = read(file);
        double allSum = 0.0;

        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(j).length; j++) {
                String money = getMoneyToStr(input.get(i), "\\d{2,3} \\d{2} BGN")
                        .replaceAll(" BGN", "");
                if (!money.equalsIgnoreCase("No such matches")) {
                    allSum += Double.parseDouble(money);
                    tmp.add(money);
                    break;
                }
            }
        }
        System.out.println(tmp);
        return allSum;
    }

    protected static Double allSpendMoneyA(File file) throws FileNotFoundException {
        List<String> tmp = new ArrayList<>();
        List<String[]> input = read(file);
        double allSum = 0.0;
        String rgx = ("VIVACOM АБОНАМЕНТЕН ПЛАН | ЕЛЕКТРОХОЛД ПРОДАЖБИ АД | ЕВН ЕЛ. ЕНЕРГИЯ - ЕЛ.КАНАЛИ |  НЕТ - СЪРФ.НЕТ | ЧЕЗ");
        for (int i = 0; i < input.size(); i++) {

            if (!find(input.get(i), rgx).equalsIgnoreCase("No such matches")) {

                for (int j = 0; j < input.get(j).length; j++) {
                    String money = getMoneyToStr(input.get(i), "\\d{2,3} \\d{2} BGN")
                            .replaceAll(" BGN", "");
                    if (!money.equalsIgnoreCase("No such matches")) {
                        allSum += Double.parseDouble(money);
                        tmp.add(money);
                        break;
                    }
                }
            }
        }
        System.out.println(tmp);
        System.out.println(allSum);
        return allSum;
    }

    //// protected static String getEachMoneyToStr(String[] input, String some){
    //// Pattern datePattern = Pattern.compile(some);

    //// Matcher dateMatcher = datePattern.matcher(formatMoney(input));
    //// if (dateMatcher.find()) {
    //// StringBuilder stb = new StringBuilder();
    //// return dateMatcher.group();
    //// stb.append(input[5]);
    //// stb.append(",");
    //// stb.append(input[6]);
    //// return stb.toString();
    //// }

    //// return "No such matches";
    //// }

    // * protected static Double getMoneyLikeDigit(){}

    // ! Търси "some" само в един ред от масива
    protected static String find(String[] input, String some) {
        Pattern datePattern = Pattern.compile(some);

        for (int i = 0; i < input.length; i++) {
            Matcher dateMatcher = datePattern.matcher(input[i]);
            if (dateMatcher.find()) {
                return dateMatcher.group();
            }
        }
        return "No such matches";
    }

}
