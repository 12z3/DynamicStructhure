package dynamicsStructure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class IO {
    public static void main(String[] args) throws FileNotFoundException {

        inputStream();
        System.out.println();
        fileInputStream();
        System.out.println();
        scannerInputStream();
    }

    private static void scannerInputStream() throws FileNotFoundException {
        String path = "/Users/blagojnikolov/IdeaProjects/inTime/TMPResult-TEST.txt";
        FileInputStream in = new FileInputStream(path);
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }

    private static void fileInputStream() {
        int cnt = 0;
        try {
            File file = new File("TMPResult-TEST.txt");
            System.out.println(file.getParentFile());
            FileInputStream in = new FileInputStream(file);
            System.out.println(file.isFile());

            int x = in.read();
            while (x != -1) {
                if (cnt == 20) {
                    cnt = 0;
                    System.out.println();
                }
                System.out.print(x + " ");
                x = in.read();
                // System.out.print(Integer.toBinaryString(in.read()) + " ");
                cnt++;
            }

        } catch (FileNotFoundException e) {
            System.out.println(" -> " + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void inputStream() {
        int cnt = 0;
        String path = "/Users/blagojnikolov/IdeaProjects/inTime/TMPResult-TEST.txt";
        try {

            // FileInputStream in = new FileInputStream(path);
            FileInputStream in = new FileInputStream("TMPResult-TEST.txt");
            int x = in.read();
            while (x != -1) {
                if (cnt == 20) {
                    cnt = 0;
                    System.out.println();
                }
                System.out.print(Integer.toBinaryString(x) + " ");
                //System.out.print(x + " ");

                x = in.read();
                cnt++;
            }

        } catch (IOException e) {
            System.out.println(" -> " + e);
        }
    }
}
