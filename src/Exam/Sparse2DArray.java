package Exam;

import java.util.LinkedList;
import java.util.function.Function;

public class Sparse2DArray<T> {
    private LinkedList<Element> arr;
    private final int xSize, ySize;

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public Sparse2DArray(int x, int y) {
        arr = new LinkedList<>();
        this.xSize = x;
        this.ySize = y;
    }

    public T get (int x, int y) {
        if (x >= xSize || x < 0 || y >= ySize || y < 0) return null;
        for (int i=0; i<arr.size(); i++){
            if (arr.get(i).xIndex == x && arr.get(i).yIndex == y){
                return arr.get(i).value;
            }
        }
        return null;
    }

    public void set (int x, int y, T value) {
        if (x >= xSize || x < 0 || y >= ySize || y < 0) return;
        for (Element element : arr) {
            if (element.xIndex == x && element.yIndex == y) {
                element.value = value;
            }
        }
    }

    public boolean hasDuplicateValues(){
        for (int i=0; i<arr.size(); i++){
            for (Element element : arr) {
                if (arr.get(i).value == element.value) return false;
            }
        }
        return true;
    }

    public T[][] toArray(Function<Integer, T[]> array1dFunc, Function<Integer, T[][]> array2dFunc){
        T[][] res = array2dFunc.apply(xSize);
        boolean hasIndex = false;
        T value = null;
        for (int i=0; i<xSize; i++){
            for (int j=0; j<ySize; j++){
                for (Element element : arr) {
                    if (element.xIndex == i && element.yIndex == j) {
                        hasIndex = true;
                        value = element.value;
                        break;
                    }
                }
                if (hasIndex){
                    res[i][j] = value;
                }else{
                    res[i][j] = null;
                }
                hasIndex = false;
                value = null;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "Sparse2DArray{" +
                "arr=" + arr +
                ", xSize=" + xSize +
                ", ySize=" + ySize +
                '}';
    }

    public class Element{
        private final int xIndex;
        private final int yIndex;
        private T value;

        public Element(int xIndex, int yIndex, T value) {
            this.xIndex = xIndex;
            this.yIndex = yIndex;
            this.value = value;
        }
    }
}