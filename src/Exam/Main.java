package Exam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("1,2,3,4,5", "2,7,4,5,9", "11,543,5,99,123");
        Stream<Integer[]> st = CsvStreams.parseLines(lst.stream());
        Integer[] sums = CsvStreams.sumColumns(st);

        Sparse2DArray<String> sp = new Sparse2DArray<>(5, 5);
        sp.set(1, 4, "Hello");
        sp.set(1, 3, "erti");
        sp.set(2, 3, "N");
        sp.set(0, 2, "Gello");
        sp.sortElemenets();
        System.out.println(sp.toString());

    }
}
