package Hackerrank.ListTmp;

import java.util.ArrayList;
import java.util.HashMap;
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
        System.out.println();
        ArrayList<ArrayList<Integer>> res = diff(lst);
        for (ArrayList<Integer> l : res){
            System.out.println(l.toString());
        }
    }

    private static ArrayList<ArrayList<Integer>> diff(ArrayList<ArrayList<Integer>> lst) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        /*
        *
        * [
        * [0 0 0 0 0]
        * [0 0 0 0 0]
        * [0 0 0 0 0]
        * [0 0 0 0 0]
        * [0 0 0 0 0]
        * ]
        * */
        for (int i=0; i<lst.size(); i++){
            ArrayList<Integer> ls = new ArrayList<>();
            for (int j=0; j<lst.get(0).size(); j++){
                ls.add(0);
            }
            res.add(ls);
        }
        for (int i=0; i<lst.size(); i++){
            for (int j=0; j<lst.get(0).size(); j++){
                if (j == lst.get(0).size() / 2){
                    res.get(i).set(j ,helper(lst, i, j));
                }
                if (i == lst.size() / 2){
                    res.get(i).set(j ,helper(lst, i, j));
                }
            }
        }
        return res;
    }

    private static int helper(ArrayList<ArrayList<Integer>> lst, int x, int y){
        int res = 0;
        for (int i=0; i<lst.size(); i++){
            for (int j=0; j<lst.get(0).size(); j++){
                if (i == x || j == y){
                    res += lst.get(i).get(j);
                }
            }
        }
        return res;
    }

    private static ArrayList<ArrayList<Integer>> makeIntoCross(ArrayList<ArrayList<Integer>> lst){
        int[][] ary = new int[lst.size()][lst.get(0).size()];
        for(int i= 0; i<ary.length; i++){
            for(int j=0; j<ary[0].length; j++){
                ary[i][j]=0;
            }
        }
        int[] sumrow = new int[lst.size()];
        int[] sumcol = new int[lst.get(0).size()];
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < lst.get(0).size(); j++) {
                sum1 += lst.get(i).get(j);
            }
            sumrow[i] = sum1;
            sum1 = 0;
        }
        for (int i = 0; i < lst.get(0).size(); i++) {
            for (int j = 0; j < lst.size(); j++) {
                sum2 += lst.get(j).get(i);
            }
            sumcol[i] = sum2;
            sum2 = 0;
        }
        for (int i = 0; i < lst.size(); i++) {
            while (i != (lst.size()) / 2 && i < lst.size()) {
                ary[i][(lst.get(0).size()) / 2] = sumrow[i] + sumcol[(lst.get(0).size()) / 2] - lst.get(i).get(lst.get(0).size() / 2);
                i++;
            }
            if(i != lst.size()) {
                for (int j = 0; j < lst.get(0).size(); j++) {
                    ary[i][j] = sumrow[i] + sumcol[j] - lst.get(i).get(j);
                }
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int [] ts : ary){
            ArrayList<Integer> res1 = new ArrayList<>();
            for(int i : ts){
                res1.add(i);
            }
            res.add(res1);
        }
        System.out.println();
        return res;
    }
}
