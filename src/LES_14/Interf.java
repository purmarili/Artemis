package LES_14;

import java.util.ArrayList;

public interface Interf {
    ArrayList<String> lst = new ArrayList<>();
    void get();
    int getSize();

    default int size(){
        return lst.size();
    }
}
