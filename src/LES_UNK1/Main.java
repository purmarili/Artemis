package LES_UNK1;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private final int k = 3;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int answ = (int)Math.pow(2, n/2);

        if (n % 2 == 0) System.out.println(answ);
        else System.out.println(0);
    }
}
