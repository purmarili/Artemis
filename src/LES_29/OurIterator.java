package LES_29;

import java.util.Iterator;

public class OurIterator implements Iterable<String> {
    @Override
    public Iterator<String> iterator() {
        Iterator<String> res = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }
        };
        return res;
    }
}
