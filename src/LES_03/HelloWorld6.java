package LES_03;

import java.util.Scanner;

public class HelloWorld6 {
    public static void main(String[] args) {



        Scanner Scan = new Scanner(System.in);
        int n = Scan.nextInt();
        boolean z = false;
        while (!z) {
            if (n < 0 || n > 30000) {
                System.out.println("try again");
                n = Scan.nextInt();
            } else {
                z = true;
            }
        }
        int m = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                if (n == 1) {
                    System.out.println(n + " ");
                } else {
                    System.out.println(n + " ");
                }
            } else {
                n = (n * 3) + 1;
                System.out.println(n + " ");
            }
            m = m + 1;
        }
        System.out.println(m);


    }
}


