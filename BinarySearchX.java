package dynamicsStructhure.bS;

import java.util.Arrays;

public class BinarySearchX {
    // https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=16
    // При намаляваща редица в условията target >< middle  e и s си разменят местата.
    // target > middle -> s = m + 1 => е = m - 1;
    // target < middle -> е = m - 1 => s = m + 1;

    public static void main(String[] args) {

//        int[] arr = {2, 3, 5, 9, 14, 16, 18, 19, 20, 21};
//        int[] arr1 = {42, 33, 25, 19, 10, 8, 9, 2, 1};
        int[] arr = {0, 1, 2, 3, 6, 7, 7, 7, 9, 10};
        int[] x = {1, 2, 3, 4, 5, 6, 5, 4, 3};
        int[] x1 = {1, 2, 3, 4, 5, 6};
        int[] x2 = {6, 5, 4, 3, 2, 1};
        int[] x3 = {1, 2, 5};

        //System.out.println(ceilOrFloor(arr, 15));
        //System.out.println(binarySearch(arr, 7));
        //System.out.println(binarySearch(arr1, 11));
        //System.out.println(binarySearch(x1, 6));
        System.out.println(binarySearchA(x, 2));
        System.out.println(classicBs(x, 11));
    }

    // Намери ми най-малкото число което е по-голямо от target (ceil)
    // или най-голямото число което е по малко от target (floor). Единствената разлика е, че не трябва да връща -1.
    // Положението на указателите в този случай e: < <"target"> e s > или s = e + 1
    // <"target"> - виртуална "частица" в случая. Няма Го в редицата.
    // което е и условието за край на while(s <= e).
    // При положение, че target принадлежи на редицата, ще го намери и върне (return m) < е target s >,
    // в случая когато target не принадлржи на редицата ще върне (не -1), а floor или ceil.


    // При условие, че средният ел. е различен от търсеното число променяй по такъв начин началния и крайния индекс
    // на интервала в който търсим докато се изпълни едно от двете условия за край:
    //      1. if (a[m] == el)
    //      2. s > e -> s = e + 1;
    static int classicBs(int[] a, int el) {
        int s = 0, e = a.length - 1, m, ans = -1;
        while (s <= e) {
            m = s + ((e - s) / 2);
            if (a[m] == el) {
                ans = m;
                return ans;
            } else if (el > a[m]) {
                s = m + 1;
            } else if (el < a[m]) {
                e = m - 1;
            }
        }
        return ans;
    }

    public static int ceilOrFloor(int[] arr, int target) {
        int s = 0, e = arr.length - 1, m = 0, ceil = 0, floor = 0;
        boolean isAsc = arr[s] < arr[e];

        while (s <= e) {
            m = s + ((e - s) / 2);
            if (isAsc) {
                if (arr[m] > target) {
                    e = m - 1;
                    ceil = e;
                } else if (arr[m] < target) {
                    s = m + 1;
                    floor = s;
                } else return m;
            } else {
                if (arr[m] < target) {
                    e = m - 1;
                    ceil = e;
                } else if (arr[m] > target) {
                    s = m + 1;
                    floor = s;
                } else return m;
            }
        }

        return floor;
        //return ceil;
    }

    // Отчита дали масива е подреден във възходящ или низходящ ред: arr[s] < arr[e];.
    public static int binarySearch(int[] arr, int target) {
        int s = 0, e = arr.length - 1, m = 0, ceil = 0, floor = 0;
        boolean isAsc = arr[s] < arr[e];
        // if (target > arr[arr.length - 1]) return -1;

        if (isAsc) {
            if (target > arr[arr.length - 1]) return -1;
        } else {
            if (target > arr[0]) return -1;

        }


        while (s <= e) {
            m = s + ((e - s) / 2);
            if (isAsc) {
                if (arr[m] > target) {
                    e = m - 1;
                } else if (arr[m] < target) {
                    s = m + 1;
                } else return m;
            } else {
                if (arr[m] < target) {
                    e = m - 1;
                } else if (arr[m] > target) {
                    s = m + 1;
                } else return m;
            }
        }
        floor = e;
        ceil = s;
        return -1;
        //return floor;
        //return floor;
    }

    // Основната логика е: Дели на две, пресмята средният елемент и мести указателите на всяка итерация докато
    // target не съвпадне със средният елемент.
    // m = s + ((e - s) / 2); Това е математически еквивалентно на m = (s + e) / 2. Но при положение, че се сортират
    // много големи числа е възможно изчислената средна стойност да излезе извън обвхвата на класа Integer.
    // Което ще доведе до грешен резултат. Та проблема с превъртането на диапазона на Integer се решава като в
    // уравнението за средната стойност се включи и обвхвата на въпросния Integer: (e - s) / 2.
    // Положението на указателите в този случай когато отговора принадлежи на редицата е: < s target e >
    public static int binarySearchA(int[] arr, int target) {
        int s = 0, e = arr.length - 1, m, ceil = 0, floor = 0;
        while (s <= e) {
            m = s + ((e - s) / 2);
            if (target > arr[arr.length - 1]) return -1;

            //  if (arr[m] == target) return m;
            if (target > arr[m]) {
                s = m + 1;
            } else if (target < arr[m]) {
                e = m - 1;
            } else return m;

            floor = e;
            ceil = s;
        }
        //return -1;
        //return floor;
        return ceil;
    }

    private static void findStartEndIdx(int[] a, int target) {
        int[] result = new int[2];
        int s = 0, e = a.length - 1, p = 0;
        boolean isS = false, isE = false;

        while (p < a.length) {
            if (a[s] == target && !isS) {
                result[0] = s;
                isS = true;
                //s--;
            }
            if (a[e] == target && !isE) {
                result[1] = e;
                isE = true;
                //e++;
            }
            if (isS && isE) {
                break;
            } else {
                s++;
                e--;
            }
            p++;
        }
        System.out.println(Arrays.toString(result));
    }
}
