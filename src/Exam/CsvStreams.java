package Exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvStreams {

    public static void main(final String[] args) {
        final Stream<String> csvFilePaths;
        final Stream<String> lines;
        final Stream<Integer[]> rows;
        final Integer[] columnSums;

        csvFilePaths = filterCsvFilePaths(getFiles());

        lines = getAllLines(csvFilePaths);
        rows = parseLines(lines);
        columnSums = sumColumns(rows);

        System.out.println(Arrays.toString(columnSums));
    }

    static Stream<String> filterCsvFilePaths(final Stream<String> filePaths) {
        return filePaths.filter(x -> x.endsWith("csv"));
    }

    /*
        1, 2, 3, 4, 5 List<String>
        6, 7, 8, 9, 10 List<String>
        11, 12, 13, 14, 15 List<String>
     */
    static Stream<String> getAllLines(final Stream<String> csvFilePaths) {
        return csvFilePaths.flatMap(CsvStreams::getLinesOfFile);
    }

    static Stream<Integer[]> parseLines(final Stream<String> lines) {
        /*
            "1,2,3,4,5" -> int [] -> [1, 2, 3, 4, 5]
         */
        return lines.map(x -> {
            List<String> ls = Arrays.asList(x.split(","));
            Integer[] rest = new Integer[5];
            for (int i = 0; i < rest.length; i++) {
                rest[i] = Integer.parseInt(ls.get(i));
            }
            return rest;
        });
    }

    static Integer[] sumColumns(final Stream<Integer[]> rows) {
        List<Integer> lst = rows.map(x -> Arrays.stream(x).reduce(0, (y, elem) -> y += elem)).collect(Collectors.toList());
        Integer[] res = new Integer[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            res[i] = lst.get(i);
        }
        return res;
    }


    // Auxiliary methods possibly used for implementation!

    // returns the paths to all files in the current directory as Stream<String>. 

    static Stream<String> getFiles() {
        try {
            return Files.list(Paths.get("C:\\Users\\jemso\\Desktop\\Class\\Artemis\\src\\Exam")).map(Path::toString);
        } catch (IOException e) {
            return Stream.of();
        }
    }

    // returns all lines in a file as Stream<String>.

    static Stream<String> getLinesOfFile(final String filePath) {
        try {
            return Files.lines(Path.of(filePath));
        } catch (IOException e) {
            return Stream.empty();
        }
    }

    // adds element-wise two Integer arrays.

    static Integer[] addArrays(final Integer[] arr1, final Integer[] arr2) {
        Integer[] res = new Integer[5];
        for (int i = 0; i < 5; i++)
            res[i] = arr1[i] + arr2[i];
        return res;
    }

    // transforms an Integer Stream into an Integer array.
    static Integer[] intStreamToIntArray(final Stream<Integer> intStream) {
        return intStream.toArray(Integer[]::new);
    }

    // transforma an arbitrary array into a stream. 
    static <T> Stream<T> arrayToStream(final T[] array) {
        return Arrays.stream(array);
    }
}
