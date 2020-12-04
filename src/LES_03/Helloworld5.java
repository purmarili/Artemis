package LES_03;

import java.util.Scanner;

public class Helloworld5 {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        int n = Scan.nextInt();
        boolean z = false;
        while (!z) {
            if (n < 1 || n > 100) {
                System.out.println("try again");
                n = Scan.nextInt();
            } else {
                z = true;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int k = Scan.nextInt();
            boolean z1 = false;
            while (!z1) {
                if (k > 1000 || k < 0) {
                    System.out.println("try again");
                    k = Scan.nextInt();
                } else z1 = true;
            }
            if ((k + 3) % 10 == 0) {
                answer++;
            }
        }
        System.out.println(answer);


    }
}




