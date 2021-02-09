package Hackerrank.ListTmp;

import java.util.ArrayList;
import java.util.Scanner;

public class CrossList {

    static Scanner sc = new Scanner(System.in);

    /*
     *       0  7  3  4  1
     *       0  0  0  0  0
     *       -6 0  2  0  0
     *       0  5  0  0  9
     *       0  0  0  6  11
     *
     *       0  0  17 0  0
     *       0  0  5  0  0
     *       -4 8  -1 6  17
     *       0  0  19 0  0
     *       0  0  1  0  0
     * */
    public static void main(String[] args) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        for (int i=0; i<x; i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j=0; j<y; j++){
                tmp.add(sc.nextInt());
            }
            lst.add(tmp);
        }
        ArrayList<ArrayList<Integer>> res = makeIntoCross(lst);
        System.out.println(res.toString());
    }

    private static ArrayList<ArrayList<Integer>> makeIntoCross(ArrayList<ArrayList<Integer>> lst){
        return null;
    }
}
