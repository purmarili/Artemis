package LES_17;

import java.util.ArrayList;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(C(10, 5));
        System.out.println(stringtoInteger("-1576"));
    }

    public static int C (int n, int k){
        if (k == 0 || n == k) return 1;

        return C(n - 1, k - 1) + C(n - 1, k);
    }

    public static String integerToString(int n){
        if (n < 10) return String.valueOf(n);

        return integerToString(n / 10) + integerToString(n % 10);
    }

    public static int stringtoInteger(String s){
        if (s.charAt(0) == '-')
            return - (stringtoInteger(s.substring(1, s.length() - 1)) * 10 + stringtoInteger(s.substring(s.length() - 1)));
        if (s.length() == 1) return Integer.parseInt(s);

        return stringtoInteger(s.substring(0, s.length() - 1)) * 10 + stringtoInteger(s.substring(s.length() - 1));
    }

    // 5 3 7 9 12,  3

    public static void allCombinations(int [] arr, int n){
        allComb(arr, n, 0, new ArrayList<>(), new ArrayList<ArrayList<Integer>>());
    }

    private static void allComb(int [] arr, int n, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> all){
        if (n < 0) return;

        if (current.size() == n) all.add(current);
        if (index > arr.length) return;

    }
}
