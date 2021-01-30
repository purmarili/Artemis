package Hackerrank;

import java.util.Scanner;

public class TwoDArrayDS {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 6;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(hourglassSum(arr));
    }

    static int hourglassSum(int[][] arr) {
        int res = Integer.MIN_VALUE;
        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                tmp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                        arr[i + 1][j + 1] +
                        arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (tmp > res) res = tmp;
            }
        }
        return res;
    }
}
