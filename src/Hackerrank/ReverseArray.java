package Hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(reverseArray(arr)));
    }

    static int[] reverseArray(int[] a) {
        int [] res = new int[a.length];
        for (int i=0; i<res.length; i++){
            res[i] = a[a.length - i - 1];
        }
        return res;
    }
}
