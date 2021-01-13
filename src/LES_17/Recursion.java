package LES_17;

import java.util.Scanner;

public class Recursion {

    static Scanner sc = new Scanner(System.in);

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


}
