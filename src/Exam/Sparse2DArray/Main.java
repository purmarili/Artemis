package Exam.Sparse2DArray;

import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<Integer, String[][]> arr2d = new Function<Integer, String[][]>() {
            @Override
            public String[][] apply(Integer integer) {
                return new String[integer][];
            }
        };
        Function<Integer, String[]> arr1d = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };

        Sparse2DArray<String> sp = new Sparse2DArray<>(4, 5);
        sp.set(0, 3, "Hello");
        sp.set(1, 1, "Bob");
        sp.set(0, 2, "Marley");
        sp.set(2, 4, "Jenkins");
        sp.set(3, 0, "Stan");

        String[][] str = sp.toArray(arr1d, arr2d);
        for (String[] strings : str) {
            for (int j = 0; j < str[0].length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
        System.out.println(sp.toString());

    }
}
