package dynamicsStructhure;

import training.Methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile extends Methods {
    public static void main(String[] args) {
        // String path = "/Users/blagojnikolov/Desktop/Test";
        // File file = new File(path);

        String separator = File.separator;                 // Статичен метод "separator" на класа "File"
                                                           // Автоматично избира типа на "separator" за конкретната ОС.
//        String path = separator + "Users" + separator +
//                "blagojnikolov" + separator + "Desktop" + separator + "Test.txt";
        String path = "Test.txt";
        File file = new File(path);                        // Създава "нов" файл от посоченият път

        String[] data = new String[5];
        StringBuilder word = new StringBuilder();
        List<Object> lData = new ArrayList<>();             // В този лист могат да се пазят Всякакви Обекти.
        int i = 0;

        Scanner scanner = null;                // Тук е Тънкият момент.
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextByte()) {
//            System.out.println(scanner.next());
//            data[i++] = (scanner.next());
//            word.append(scanner.nextLine());
            lData.add(scanner.nextLine());
        }

        for(Object elm: lData){                              // Типа е "Object" - генералният.
            System.out.println(elm);
        }
        System.out.println(lData);
//        for(String elm1: data){
//            System.out.println(elm1);
//        }
//        System.out.println(word);
        scanner.close();
    }
}
