package LES_02;

import java.lang.reflect.Array;
import java.util.ArrayList;

class MyList{
    private int size;
    private int [] arr;

    public MyList(int size){
        this.size = size;
        this.arr = new int[size];
    }

    public int getElement(int index){
        return arr[index];
    }

}

public class Main {
    public static void main(String[] args) {

        String str = "Hello";
        int [] arr = new int[50];
        ArrayList<Integer> lst = new ArrayList<>(50);
        MyList a = new MyList(50);
        a.getElement(5);
    }


}
