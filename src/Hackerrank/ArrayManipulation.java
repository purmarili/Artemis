package Hackerrank;

import java.util.Scanner;

public class ArrayManipulation {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a, b;
        long k;
        int n = sc.nextInt();
        long m = sc.nextInt();
        long[] arr = new long[n + 1];

        // M*N

        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            k = sc.nextLong();
            for (int j = a - 1; j < b; j++) {
                arr[j] += k;
            }
        }
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        System.out.println(max);
    }

    static int get() {
        int N = sc.nextInt();
        int M = sc.nextInt();

        /*

            0 0 0 0 0 0
            100 -100 0 0 0 0
            100 0 0 0 0

         */

        /* Save interval endpoint's "k" values in array */
        long[] array = new long[N + 1];
        while (M > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            array[a - 1] += k;
            array[b] -= k;
            M--;
        }
        return 0;
    }
}
