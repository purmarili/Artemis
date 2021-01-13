package LES_19;

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        System.out.println(isNumberPalindrome(n, 0));

//        int n = sc.nextInt();
//        int [] arr = new int[n];
//        n = sc.nextInt();
//        for (int i=0; i<arr.length; i++){
//            arr[i] = sc.nextInt();
//        }
//        allCombinations(arr, n);

    }
    // 135531
    public static boolean isNumberPalindrome(int n, int index){
        int size = 0, n1 = n, n2 = n, n3 = n, temp1 = index, temp2;
        while (n1 > 0){
            size++;
            n1 /= 10;
        }
        temp2 = size - index;
        if (size / 2 == index) return true;

        while (temp1 > 0){
            n2 /= 10;
            temp1--;
        }
        int last = n2 % 10;
        while (temp2 > 1) {
            n3 /= 10;
            temp2--;
        }
        int first = n3 % 10;
        if (first != last) return false;

        return isNumberPalindrome(n, index + 1);
    }

    // 5 3 7 9 12,  3

    public static void allCombinations(int [] arr, int n){
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        allComb(arr, n, n,0, new ArrayList<>(), all);

        for (int i=0; i<all.size(); i++){
            System.out.println(all.get(i).toString());
        }
    }

    // 1, 2, 3
    // n -> 2

    /*
                                                    1 (2, 0, ())
                            2 (1, 1, (1))                                      2 (2, 1, ())
         3 (0, 2, (1, 2))            3(1, 2, (1))                      3(1, 2, (2))                        3(1, 2, ())
                         4(0, 3, (1, 3))      4(1, 3, (1))   4(0, 3, (2, 3))    4(0, 3, (2))        4(0, 3, (3))       4(0, 3, ())

     */
    private static void allComb(int [] arr, int n, int temp, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> all){
        if (n < 0) return;
        if (current.size() == temp){
            ArrayList<Integer> copy = new ArrayList<>(current);
            all.add(copy);
            return;
        }
        if (index >= arr.length) return;

        current.add(arr[index]);
        allComb(arr, n - 1, temp, index + 1, current, all);
        current.remove(current.size() - 1);
        allComb(arr, n, temp,index + 1, current, all);
    }
}
