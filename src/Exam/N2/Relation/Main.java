package Exam.N2.Relation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Relation<String, Integer> rel = new Relation<String, Integer>() {
            @Override
            public boolean test(String s, Integer k) {
                return s.length() == k;
            }
        };

        Relation<String, Integer> other = new Relation<String, Integer>() {
            @Override
            public boolean test(String s, Integer k) {
                return Integer.parseInt(String.valueOf(s.charAt(0))) == k;
            }
        };


        Predicate<String> p = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 5;
            }
        };

        Function<List<String>, String> f = new Function<List<String>, String>() {
            @Override
            public String apply(List<String> s) {
                return s.get(2);
            }
        };

//        String s = sc.nextLine();
//        int a = sc.nextInt();
        List<String> lst = new ArrayList<>();
        for (int i=0; i<3; i++){
            lst.add(sc.nextLine());
        }

        System.out.println(rel.compose(f).test(lst, 5));

    }
}
