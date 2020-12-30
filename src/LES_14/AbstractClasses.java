package LES_14;

import java.util.ArrayList;

public abstract class AbstractClasses {
    private ArrayList<String> lst = new ArrayList<>();
    abstract void add();
    abstract int get();
    public int size(){
        return 0;
    }
    private ArrayList<String> divideList(){
        return null;
    }
    void print(){
        for (String s : lst)
            System.out.println(s);
    }
}
