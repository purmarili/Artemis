package Exam.CsvStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("1,2,3,4,5", "2,7,4,5,9", "11,543,5,99,123");
        Stream<Integer[]> st = CsvStreams.parseLines(lst.stream());
        Integer[] sums = CsvStreams.sumColumns(st);
    }
}
