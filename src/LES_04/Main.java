package LES_04;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        tba[] tbaa = new tba[20];
        int sigrme = 10;
        for (int i = 0; i < 20; i++) {
            tbaa[i] = new tba();
            sigrme = rand.nextInt(150);
            int fartobi = rand.nextInt();
            tbaa[i].setSaxeli("tba nomeri" + Integer.toString(i));
            tbaa[i].setSigrme(sigrme);
            tbaa[i].setFartobi(fartobi);
        }
        int max = tbaa[0].getSigrme();
        for (int i = 0; i < 20; i++) {
            if (max < tbaa[i].getSigrme()) {
                max = tbaa[i].getSigrme();
            }
        }
        System.out.println(max);
    }
}






//    public static int binom(int n, int k)
//    {
//
//        // Base Cases
//        if (k > n)
//            return 0;
//        if (k == 0 || k == n)
//            return 1;
//
//        // Recur
//        return binom(n - 1, k - 1) +
//                binom(n - 1, k);
//    }
//
//
//}