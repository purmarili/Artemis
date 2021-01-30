package LES_26;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static String baz(int x) {
        String res = "";
        switch (x) {
            case 0:
                res += "Pinguin ";
            case 1:
                res += 10 / 3 + " ";
            case 2:
                res += "added->2 ";
            default:
                res += "def";
        }
        return res;
    }
}
