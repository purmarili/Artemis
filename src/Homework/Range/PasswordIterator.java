package Homework.Range;

import java.util.ArrayList;
import java.util.Iterator;

public class PasswordIterator implements Iterator<String> {

    private final int passwordLength;
    private long possibilities;
    private int used = 0;
    private ArrayList<String> lst = new ArrayList<>();
    private long lstSize;
    private long current = 0;


    public PasswordIterator(int passwordLength) {
        this.passwordLength = passwordLength;
        if (passwordLength < 1 || passwordLength > 9) {
            throw new IllegalArgumentException("expected number from 0 to 10");
        }
        possibilities = 10;
        int tmp = 10;
        for (int i=1; i<passwordLength; i++)
            possibilities *= tmp;

        for (int i=0; i<10; i++) {
            String str = "";
            for (int j = 0; j < passwordLength; j++) {
                str += Integer.toString(i);
            }
            lst.add(str);
        }
        for (int i=0; i<10 - passwordLength + 1; i++) {
            String str = "";
            for (int j = i; j < i+passwordLength; j++) {
                str += Integer.toString(j);
            }
            if (!lst.contains(str))
            lst.add(str);
        }

        for (int i=9; i>passwordLength-2; i--) {
            String str = "";
            for (int j = i; j > i-passwordLength; j--) {
                str += Integer.toString(j);
            }
            if (!lst.contains(str))
                lst.add(str);
        }

        this.lstSize = lst.size();
    }

    public boolean hasNext() {
        return possibilities > used;
    }

    public String next() {
        if (lstSize > used){
            String str = lst.get(used);
            used++;
            return str;
        }
        while (lst.contains(Main.longToStringWithLength(current, passwordLength))){
            current++;
        }
        long curr = current;
        used++;
        current++;
        return Main.longToStringWithLength(curr, passwordLength);

    }

//    private String getNext(int ){
//
//    }
}