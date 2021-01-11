package Homework.BreakingCodes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Range r = new Range(-4, -13, 3);
        Iterator<Integer> iter = r.iterator();
//
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }

        String salt = "HELLO";
        int saltedPasswordHashValue = 1009959;
        int passwordLength = 5;

        Function<String, Integer> hashFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.substring(0, 4)) + s.substring(4).length() + 1000007;
            }
        };

        System.out.println(PasswordBreaker.findPassword(hashFunction, passwordLength, salt, saltedPasswordHashValue));
    }

}
