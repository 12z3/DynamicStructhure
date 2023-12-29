package dynamicsStructure;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Jackpot {
    public static void main(String[] args) throws IOException {
        int choices = 3, counting = 6, idx = 1;

        List<Integer> officialResult = Arrays.asList(23, 26, 27, 31, 38, 47);
        System.out.println("Последно теглене: " + officialResult + "\n");

        List<List<Integer>> newDraw = generateRandomResults(choices, counting, officialResult);
        for (List<Integer> item : newDraw) System.out.println((idx++) + ". " + item);

        String check = (checkResults(newDraw, officialResult) == 1) ? "Дублира се. " : "Няма дублирани елементи.";
        System.out.println(check + "\n");
        saveInFile(newDraw, officialResult);

        checkJackpot(newDraw, officialResult);
    }

    private static List<List<Integer>> generateRandomResults(int choices, int counting, List<Integer> official) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        List<List<Integer>> resList = new ArrayList<>();
        Set<Integer> addedDigit = new HashSet<>();
        List<Integer> result;

        System.out.print("Да се отчита ли предишното теглене?  (Y / N): ");
        String answer = scanner.nextLine();
        boolean draw = validatedAnswers(answer).equalsIgnoreCase("Y");

        for (int i = 0; i < choices; i++) {
            Set<Integer> tmp = new HashSet<>();
            for (int j = 0; j < counting; j++) {
                int newEl = rnd.nextInt(1, 50);
                if (draw) {
                    if (!addedDigit.contains(newEl) && !tmp.contains(newEl)) {
                        tmp.add(newEl);
                        addedDigit.add(newEl);
                    } else {
                        j--;
                    }
                } else {
                    if (!addedDigit.contains(newEl) && !tmp.contains(newEl) && !official.contains(newEl)) {
                        tmp.add(newEl);
                        addedDigit.add(newEl);
                    } else {
                        j--;
                    }
                }
            }
            result = new ArrayList<>(tmp);
            Collections.sort(result);
            resList.add(result);
        }
        return resList;
    }

    private static void saveInFile(List<List<Integer>> res, List<Integer> official) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("tResN.txt");
        boolean doDelete;

        System.out.print("Да се запазят ли предишните резултати (Y / N) или (E) за изход: ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("E")) {
            return;  // последен метод е - 23 ред.
        } else doDelete = validatedAnswers(answer).equalsIgnoreCase("Y");

        //doDelete = validatedAnswers(answer).equalsIgnoreCase("Y") ? true : false;
        writer(res, official, file, doDelete);
    }

    private static void writer(List<List<Integer>> res, List<Integer> official, File file, boolean doDelete)
            throws IOException {

        FileWriter writer = new FileWriter(file, doDelete);

        writer.write("\n" + "Последно тегелене: " + official.toString() + "\n");
        writer.write("---------------------------" + "\n");
        writer.write("Предложения: " + "\n");
        for (int i = 0; i < res.size(); i++) {
            writer.write((i + 1) + ". " + res.get(i).toString() + "\n");
        }
        System.out.println("Резултата е записан в: " + file.getAbsolutePath());
        writer.write("---------------------------" + "\n");
        writer.write(getDateAndTime() + "\n");
        writer.write(dateFromNextDraw() + "\n");
        writer.close();
    }

    private static String validatedAnswers(String answer) {
        Scanner scanner = new Scanner(System.in);
        while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
            System.out.print("Y / N: ");
            answer = scanner.nextLine();
        }
        //scanner.close();;
        return answer;
    }

    private static String getDateAndTime() {
        DateTimeFormatter formatDate =
                DateTimeFormatter.ofPattern("dd MMM yyyy, E - a- c 'ден:' HH:mm:ss ч ");

        LocalDateTime now = LocalDateTime.now();
        return now.format(formatDate);
    }

    private static String dateFromNextDraw() {
        LocalDateTime now = LocalDateTime.now();

        Integer[] drawDays = {3, 8};
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        String thisDayStr = String.valueOf(now.getDayOfWeek());
        String drawDay = "";
        String printDay;
        String resStr;
        int thisDay = -1;
        int leftDays = -1;

        //long daysDifference = ChronoUnit.DAYS.between();
        //System.out.println(String.valueOf(now.getDayOfWeek()));

        for (int i = 0; i < days.length; i++) {
            if (days[i].equalsIgnoreCase(thisDayStr)) thisDay = i;
        }

        // TODO: Много е съмнителна логиката.
        if (thisDay == drawDays[0]) {
            leftDays = 0;
            drawDay = "Четвъртък";
        } else if (thisDay < drawDays[0]) {
            leftDays = thisDay - drawDays[0];
            drawDay = "Четвъртък";
        } else if (thisDay > drawDays[0] && thisDay < drawDays[1]) {
            leftDays = (thisDay + 1) - drawDays[1];
            drawDay = "Неделя";
        } else if (thisDay == drawDays[1]) {
            leftDays = 0;
            drawDay = "Неделя";
        }

        thisDayStr = getCurrentDay(thisDayStr);

        printDay = (Math.abs(leftDays) == 1) ? " ден." : " дни.";

        String resStrA = ("Днес е " + thisDayStr + ", следващият тираж е в " + drawDay +
                ". Остават " + Math.abs(leftDays) + printDay);

        String resStrB = (thisDayStr + " e." + " Ден за ПЕЧАЛБИ!  ;) ");

        resStr = (leftDays == 0) ? resStrB : resStrA;
        return resStr;
    }

    private static String getCurrentDay(String thisDayStr) {
        switch (thisDayStr) {
            case "MONDAY" -> thisDayStr = "Понеделник";
            case "TUESDAY" -> thisDayStr = "Вторник";
            case "WEDNESDAY" -> thisDayStr = "Сряда";
            case "THURSDAY" -> thisDayStr = "Четвъртък";
            case "FRIDAY" -> thisDayStr = "Петък";
            case "SATURDAY" -> thisDayStr = "Събота";
            case "SUNDAY" -> thisDayStr = "Неделя";
        }
        return thisDayStr;
    }

    private static int checkResults(List<List<Integer>> res, List<Integer> official) {
        Set<Integer> officialSet = new HashSet<>(official);
        Map<Integer, List<Integer>> rowCol;
        List<Integer> matches;
        int isMatch = -1;
        for (int i = 0; i < res.size(); i++) {
            rowCol = new TreeMap<>();
            for (int j = 0; j < res.get(i).size(); j++) {
                matches = new ArrayList<>();
                if (officialSet.contains(res.get(i).get(j))) {
                    matches.add(res.get(i).get(j));
                    rowCol.put(i, matches);
                    System.out.println(("Ред: " + (i + 1)) + " Колона: " + j + " - " + matches + " ");
                    //printMap(rowCol, res.get(i).get(j));
                    isMatch = 1;
                }
            }
        }
        return isMatch;
    }

    private static void checkJackpot(List<List<Integer>> yoursSuppose, List<Integer> currentDraw) {
        List<Integer> matches = null;
        for (int i = 0; i < yoursSuppose.size(); i++) {
            Set<Integer> tmp = new HashSet<>(yoursSuppose.get(i));
            System.out.println("---------------------------");
            System.out.println(yoursSuppose.get(i));
            matches = new ArrayList<>();
            for (int j = 0; j < tmp.size(); j++) {
                if (tmp.contains(currentDraw.get(j))) {
                    matches.add(currentDraw.get(j));
                    System.out.print(("Ред: " + (i + 1)) + " Колона: " + j + " - " + matches + " " + "\n");
                    System.out.println("---------------------------" + "\n");
                }
            }
            System.out.println();
        }
    }

    private static void printMatches(List<Integer> matches) {
        for (int i = 0; i < matches.size(); i++) {
            System.out.printf("Съвпадения: ");
        }
    }

    private static void printMap(Map<Integer, List<Integer>> map, int digit) {
        for (Map.Entry<Integer, List<Integer>> el : map.entrySet()) {
            System.out.printf("Ред: %d; -> %d%n", el.getKey(), digit);
        }
    }

    private static int checkResultsOld(List<List<Integer>> res, List<Integer> official) {
        for (List<Integer> item : res) {
            for (int i = 0; i < item.size(); i++) {
                for (int j = 0; j < official.size(); j++) {
                    if (item.get(i).equals(official.get(j))) {
                        System.out.printf("ERROR :( -> %d ", official.get(j));
                        return 1;
                    }
                }
            }
        }
        return -1;
    }
}
