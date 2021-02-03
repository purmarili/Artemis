package Exam.Retake.First;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class Sorts implements Iterable<Integer> {
    private boolean[] arr;
    private int indexOfIterator;
    private int size;

    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                boolean found = false;
                for (int i=indexOfIterator; i<arr.length; i++){
                    if (arr[i]){
                        indexOfIterator = i;
                        found = true;
                        break;
                    }
                }
                return found;
            }

            @Override
            public Integer next() {
                indexOfIterator++;
                return indexOfIterator - 1;
            }
        };
        return it;
    }

    public Sorts(int n, Stream<Integer> s) {
        if (n < 0) throw new IllegalArgumentException();
        arr = new boolean[n];
        for (int i=0; i<n; i++){
            arr[i] = false;
        }
        List<Integer> lst = s.collect(Collectors.toList());
        for (int i=0; i<lst.size(); i++){
            if (lst.get(i) < 0) throw new IllegalArgumentException();
            arr[lst.get(i)] = true;
        }
        size = lst.get(lst.size() - 1);
    }

    public boolean isEmpty() {
        for (int i=0; i<arr.length; i++){
            if (arr[i]) return true;
        }
        return false;
    }

    public void remove(Integer x) {
        if (x < 0 || x >= arr.length) throw new IllegalArgumentException();
        arr[x] = false;
    }

    public Integer[] sorted() {
        int count = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]) count++;
        }
        Integer [] res = new Integer[count];
        int index = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]){
                res[index] = i;
                index++;
            }
        }
        return res;
    }

    public void meet(Sorts b) {
        Integer [] second = b.sorted();
        int size = second[second.length - 1] < this.size ? second.length : this.size;
        boolean [] change = new boolean [size];
        boolean [] tmp = new boolean[second[second.length - 1]];
        for (int i=0; i<second.length; i++){
            tmp[second[i]] = true;
        }
        for (int i=0; i< change.length; i++){
            if (tmp[i] && arr[i]) change[i] = true;
        }
        this.arr = change;
    }
}

