package LES_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(6,32,9,-1);

        // demonstration of map method
        List<Integer> square = numbers.stream().map(x -> x * x).
                collect(Collectors.toList());

        System.out.println(square);

        // create a list of String
        List<String> names =
                Arrays.asList("Reflection","Collection","Stream");

        // demonstration of filter method
//        String str = "Hello";
//        System.out.println(str.startsWith("H"));
        List<String> result = names.stream().filter(s -> !s.startsWith("S")).
                collect(Collectors.toList());
        System.out.println(result);

        // demonstration of sorted method
        List<Integer> show =
                numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(show);

//      create a list of integers
        List<Integer> numbers1 = Arrays.asList(2,3,4,5,2);

        // collect method returns a set
        Set<Integer> squareSet =
                numbers1.stream().map(x->x*x).collect(Collectors.toSet());
        System.out.println(squareSet);

        // demonstration of forEach method
        numbers1.stream().forEach(y->System.out.println(y));

        // demonstration of reduce method
        int even = numbers1.stream().map(x->x*x).map(x->x * 2).filter(x->x%2==0).sorted().reduce(0,(ans,i)-> ans+i);

        System.out.println(even);
    }
}
