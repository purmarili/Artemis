package Hackerrank;

import java.util.Scanner;

public class ArrayManipulation {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(get());
    }

    static long get() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        /* Save interval endpoint's "k" values in array */
        long[] arr = new long[N + 1];
        while (M > 0) {
            int a = sc.nextInt(); // 2
            int b = sc.nextInt(); // 4
            int k = sc.nextInt(); // 100
            arr[a - 1] += k;
            arr[b] -= k;
            M--;
        }
        /*
         *   1 2 3 4 5 6
         *  [0 0 0 0 0 0]
         *  [0 100 0 0 0 0] -> a=2, b=3, k=100
         *  [0 100 50 0 0 0] -> a=3, b=3, k=50
         *    -> a=4
         *
         * */
        long max = arr[0];
        long sum = arr[0];
        for (int i=1; i<arr.length - 1; i++){
            sum += arr[i];
            if (sum > max) max = sum; // 150
        }
        return max;
    }
}
