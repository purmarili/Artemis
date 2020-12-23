package LES_11;

public interface OurList<T> {
    public void add(T newElem);
    public void delete(int index);
    public boolean isEmpty();
    public int size();
    public boolean contains(T elem);
    public Object get(int index);
    default int getK(int a, int b){
        return a + b;
    }
}
