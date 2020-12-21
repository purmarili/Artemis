package LES_11;

import java.util.function.Predicate;

public class OurArrayList<T> implements OurList<T>{
    private Object [] data;
    private int allocated = 10;
    private int size = 0;

    public OurArrayList(){
        data = new Object[allocated];
    }

    @Override
    public void add(T newElem) {
        if (allocated == size - 1){
            grow();
        }
        data[size] = newElem;
        size++;
    }

    private void grow(){
        allocated *= 2;
        Object [] newData = new Object[allocated];
        for (int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) return;

        Object [] newData = new Object [allocated];
        for (int i=0; i<index; i++){
            newData[i] = data[i];
        }
        for (int i=index; i<size - 1; i++){
            newData[i] = data[i + 1];
        }
        data = newData;
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T elem) {
        for (int i=0; i<size; i++){
            if (data[i].equals(elem)) return true;
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        return (T) data[index];
    }
}
