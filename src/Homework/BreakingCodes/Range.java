package Homework.BreakingCodes;

import java.util.Iterator;

public class Range implements Iterable<Integer> {
    private final int begin;
    private final int end;
    private final int stride;
    private int current;
    private boolean isNegative = false;

    public Range(int begin, int end){
        if (begin > end) {
            isNegative = true;
            begin *= -1;
            end *= -1;
        }
        this.begin = begin;
        this.end = end;
        this.stride = 1;
        current = this.begin;
    }

    public Range(int begin, int end, int stride){
        if (begin > end) {
            isNegative = true;
            begin *= -1;
            end *= -1;
        }
        this.begin = begin;
        this.end = end;
        this.stride = stride;
        current = this.begin;
    }

    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return current <= end;
            }

            @Override
            public Integer next() {
                if (! hasNext()) Util.noSuchElement("no more element");
                int temp = current;
                current += stride;
                if (isNegative) return -temp;
                return temp;
            }
        };
    }

}
