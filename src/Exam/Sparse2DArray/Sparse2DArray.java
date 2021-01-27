package Exam.Sparse2DArray;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Sparse2DArray<T> {
    private int sizeX;
    private int sizeY;
    private List<Element> elems;

    @Override
    public String toString() {
        String s = "";
        for (Element e : elems){
            s += e.getX() + " " + e.getY() + " " + e.getValue();
            s += "\n";
        }
        return s;
    }

    public Sparse2DArray(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        elems = new LinkedList<>();
    }

    public T[][] toArray(Function<Integer, T[]> array1dFunc, Function<Integer, T[][]> array2dFunc){

        T[][] res = array2dFunc.apply(sizeX);
        for (int i=0; i<sizeX; i++){
            T[] curr = array1dFunc.apply(sizeY);
            res[i] = curr;
        }
        for (int i=0; i<res.length; i++){
            for (int j=0; j<res[0].length; j++){
                res[i][j] = null;
            }
        }
        for (Element elem : elems){
            int x = elem.getX();
            int y = elem.getY();
            res[x][y] = elem.getValue();
        }
        return res;
    }

    public static <T> Sparse2DArray<T> fromArray(T[][] array2d){
        if (array2d == null) throw new RuntimeException();
        for (int i=0; i<array2d.length; i++){
            if (array2d[i] == null) throw new RuntimeException();
        }
        for (int i=1; i<array2d.length; i++){
            if (array2d[i - 1].length != array2d[i].length) throw new RuntimeException();
        }

        Sparse2DArray<T> res = new Sparse2DArray<>(array2d.length, array2d[0].length);
        for (int i=0; i< array2d.length; i++){
            for (int j=0; j<array2d[0].length; j++){
                res.set(i, j, array2d[i][j]);
            }
        }

        return res;

    }

    public void sortElemenets(){
        Collections.sort(elems, Comparator.comparingInt(Element::getX)
                                .thenComparingInt(Element::getY));
    }

    public T get(int x, int y){
        if (x < 0 || x >= sizeX || y < 0 || y >= sizeY)
            throw new IndexOutOfBoundsException();
        for (Element e : elems){
            if (e.getX() == x && e.getY() == y){
                return e.getValue();
            }
        }
        return null;
    }

    public void set(int x, int y, T value){
        if (x < 0 || x >= sizeX || y < 0 || y >= sizeY)
            throw new IndexOutOfBoundsException();

        for (Element e : elems){
            if (e.getX() == x && e.getY() == y){
                if (value == null){
                    elems.remove(e);
                }else{
                    e.setValue(value);
                }
            }
        }
        if (value == null) return;

        Element elem = new Element(x, y, value);
        elems.add(elem);

    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public class Element {
        private int x;
        private int y;
        private T elem;

        public Element(int x, int y, T elem){
            this.x = x;
            this.y = y;
            if (elem == null)
                throw new RuntimeException();
            this.elem = elem;
        }

        public int getX() {
            return x;
        }

        public int getY(){
            return y;
        }

        public T getValue(){
            return elem;
        }

        public void setValue(T elem){
            this.elem = elem;
        }
    }
}