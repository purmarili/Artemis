package Range;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        PasswordIterator it = new PasswordIterator(4);
        while (it.hasNext())
            System.out.println(it.next());

    }

    public static String longToStringWithLength(long value, int length) {
        return String.format("%0" + length + "d", value);
    }

}
