package Hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeftRotation {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size = sc.nextInt();
        int d = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i=0; i<size; i++){
            arr.add(sc.nextInt());
        }
        System.out.println(rotateLeft(d, arr).toString());
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        d = d & arr.size();
        for (int i=0; i<d; i++){
            int tmp = arr.get(0);
            for (int j=0; j<arr.size() - 1; j++){
                arr.set(j, arr.get(j + 1));
            }
            arr.set(arr.size() - 1, tmp);
        }
        return arr;
    }
}
