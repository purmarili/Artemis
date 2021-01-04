package LES_15;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Other {
    private static Scanner sc = new Scanner(System.in);
    private static int count = 0;
    private static ArrayList<String> palindromes = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(isPalindromeRec("HELLEH"));

        countDifferentPalindromes("gamarjobabojramag");
        System.out.println(palindromes.size());
    }

    // HH
    private static void countDifferentPalindromes(String s){
        if (s.length() == 0) return;
        if (isPalindromeRec(s) && (!palindromes.contains(s))) {
            palindromes.add(s);
        }
        if (s.length() < 2) {
            if (!palindromes.contains(s))
                palindromes.add(s);
            return;
        }

        countDifferentPalindromes(s.substring(1));
        countDifferentPalindromes(s.substring(0, s.length() - 1));
        countDifferentPalindromes(s.substring(1, s.length() - 1));
    }

    private static boolean isPalindromeRec(String s){
        if (s.length() < 2) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;

        return isPalindrome(s.substring(1, s.length() - 1));
    }

    private static boolean isPalindrome(String s){
        for (int i=0; i<s.length() / 2; i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    private static void longestH(){
        int[] matrix = {5, 7, 2, 15, 3, 9, 11, 0, -17, -65, 125, 0, 8, 1, 5, -5, 99999, 99, -45, -1, 0, 5};
        int max = 1;
        int index = 0;
        for (int i=0; i<matrix.length; i++){
            int count = 1;
            while (index < matrix.length - 1 && matrix[index] < matrix[index + 1]){
                index++;
                count++;
            }
            i = index + 1;
            index = i;
            if (max < count) max = count;
        }

        System.out.println(max);
    }
}
