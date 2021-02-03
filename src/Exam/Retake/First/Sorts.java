package Exam.Retake.First;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class Sorts implements Iterable<Integer> {
    private boolean[] arr;
    private int indexOfIterator;

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return indexOfIterator < arr.length;
            }

            @Override
            public Integer next() {
                for (int i=indexOfIterator; i<arr.length; i++){
                    if (arr[i]) {
                        indexOfIterator = i;
                        break;
                    }
                }
                indexOfIterator++;
                return indexOfIterator - 1;
            }
        };
    }

    public Sorts(int n, Stream<Integer> s) {
        List<Integer> lst = s.collect(Collectors.toList());
        for (int i=0; i<lst.size(); i++){
            if (lst.get(i) < 0 || lst.get(i) > n) throw new IllegalArgumentException();
        }
        int max = 0;
        for (int i=0; i<lst.size(); i++){
            if (lst.get(i) > max) max = lst.get(i);
        }
        arr = new boolean[max + 1];
        for (int i=0; i<lst.size(); i++){
            arr[lst.get(i)] = true;
        }
    }

    public boolean isEmpty() {
        for (int i=0; i<arr.length; i++){
            if (arr[i]) return false;
        }
        return true;
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
            if (arr[i]) {
                res[index] = i;
                index++;
            }
        }
        return res;
    }

    public void meet(Sorts b) {
        int size = 0;
        if (b.arr.length > this.arr.length){
            size = this.arr.length;
        }else{
            size = b.arr.length;
        }
        boolean [] newArr = new boolean[size];
        for (int i=0; i< newArr.length; i++){
            if (this.arr[i] && b.arr[i]){
                newArr[i] = true;
            }
        }
        this.arr = newArr;
    }
}

