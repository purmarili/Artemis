package Homework.BreakingCodes;

import Homework.Range.PasswordIterator;

import java.util.function.Function;

public class PasswordBreaker {

    public static String findPassword(Function<String, Integer> hashFunction, int passwordLength,
            String salt, int saltedPasswordHashValue) {
        
        if (salt == null || hashFunction == null) {
            throw new IllegalArgumentException("null was provided");
        }

        PasswordIterator it = new PasswordIterator(passwordLength);
        while (it.hasNext()){
            String str = it.next();
            String pass = str + salt;
            Integer code = hashFunction.apply(pass);
            if (code == saltedPasswordHashValue)
                return str;
        }
        return null;
    }

}
