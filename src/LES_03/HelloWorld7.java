package LES_03;

import java.util.Scanner;

public class HelloWorld7 {

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        int n = Scan.nextInt();
        boolean z = false;
        while (!z) {
            if (n < 0 || n > 1000000000) {
                System.out.println("try again");
                n = Scan.nextInt();
            } else {
                z = true;
            }
        }
        int answer = 0;
        int pos = 1;
        while (pos != n) {
            if (pos < n) {
                pos = pos * 2;
                answer = answer + 1;
            } else {
                for (int pos1 = 1; pos > n; pos1 = pos1 * 2) {
                    pos = pos - pos1;
                    answer = answer + 1;
                }
            }
        }
        System.out.println(answer + 1);


    }


}
