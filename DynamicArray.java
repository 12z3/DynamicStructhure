package DynamicsStructhure;

import training.Methods;
import java.util.Scanner;

public class DynamicArray extends Methods {

    // https://softuni.bg/trainings/resources/video/62383/video-02-july-2021-georgi-georgiev-data-structures-fundamentals-with-java-june-2021/3417

    /**
     * Проверява дали индекса е валиден.
     * @param arr -> Проверявания масив
     * @return -> резултата от проверката.
     */

    public static boolean checkPosition(int[] arr) {
        int size = arr.length;
        boolean isNoValidIndex = false;
        try {
            if (size > arr.length) {
                isNoValidIndex = true;
                throw new ArrayIndexOutOfBoundsException();
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.print("Index Out Of Bounds");
        }
      return isNoValidIndex;
    }

    public static void addElementIntoArray(int newElement, int[] arr, int index) {
        int size = arr.length;
        int countZeroElement = 0;

        if (checkPosition(arr)){
            System.out.println("Index is OUT Of BOUNDS!");
            return;
        }
            for (int i = 0; i < size; i++) {
                if (arr[i] == 0) {
                    countZeroElement++;
                }
            }

        if (countZeroElement <= 3) {
            int[] temp = new int[size + size / 2];
            for (int i = 0; i < size; i++) {             // {1, 2, 5, 3, 67, 8, 9, 0, 0, 0, 0};
                temp[i] = arr[i];                        //  0  1  2  3  4   5  6 - indexes.
            }
            arr = temp;                                  // Изчиства от памета старият масив "arr"  <-- !!!
        }
                                                         // Отзад напред до "index" включително <--
        for (int i = size; i >= index; i--) {   // Премества елементи на ДЯСНО, започвайки от от "size" с една позиция.
            arr[i] = arr[i - 1];                         // Последният става = на предпоследният и т.н. до index вкл.
        }                                                // "i = size" това налага size = arr.length - 1;

        try {
            arr[index] = newElement;                     // На позиция "index" слага новият елемент.
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ERROR");
        }

        printArrayWithOutZeroElements(arr);
    }

    public static void removeElementFromArray(int index, int[] arr) {
        int size = arr.length;

        if (checkPosition(arr)){
            System.out.println("Index is OUT Of BOUNDS!");
            return;
        }
        int removedEl = arr[index];
                                                        // От следващият след "index" елем. до последният.
        for (int i = index + 1; i < arr.length; i++) {  // Тъйкато е "arr[i - 1] = arr[i]" то трябва "i = index + 1".
            arr[i - 1] = arr[i];             // Премества елементи на ЛЯВО, Започвайки от "index + 1" с една позиция.
        }                                    //arr[index + 1 - 1] = arr[index];
        // size--;
       // arr[arr.length - 1] = 0;
        printArrayWithOutZeroElements(arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        timeAndData();


        int[] a = {1, 2, 5, 3, 4, 67, 9};

        printIntArray(a);
        addElementIntoArray(333, a, 3);
        removeElementFromArray(3,a);

    }
}
