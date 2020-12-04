package Range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {

    private int start;
    private int end;
    private int stride;
    private int current;
    private boolean isNegative = false;

    public Range(int start, int end){
        if (start > end) {
            isNegative = true;
            start *= -1;
            end *= -1;
        }
        this.start = start;
        this.end = end;
        this.stride = 1;
        current = this.start;
    }

    public Range(int start, int end, int stride){
        if (start > end) {
            isNegative = true;
            start *= -1;
            end *= -1;
        }
        this.start = start;
        this.end = end;
        this.stride = stride;
        current = this.start;
    }

    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return current <= end;
            }

            @Override
            public Integer next() {
                if (! hasNext())    throw new NoSuchElementException();
                int temp = current;
                current += stride;
                if (isNegative) return -temp;
                return temp;
            }
        };
    }

}
