package Homework.PenguinColonies;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        String s = "Hello";
        String p = "B";
//        s.equals(p)
//        Predicate<String> pred = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.equals("HELLO");
//            }
//        };
//        System.out.println(getName(pred));
//
//        ArrayList<? super String> lst = new ArrayList<>();
    }






    public static boolean getName(Predicate<String> pred){
        String s = "Hello";
        if (pred.test(s)) return true;

        return false;
    }
}
