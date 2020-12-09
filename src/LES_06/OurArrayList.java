package LES_06;

public class OurArrayList {
    String [] array;
    private int allocSize;
    private int usedSize;

    public OurArrayList(){
        this.array = new String[5];
        allocSize = 5;
        usedSize = 0;
    }

    public void add(String str){
        if (allocSize == usedSize){
            grow();
        }
        this.array[usedSize] = str;
        usedSize++;
    }

    private void grow() {
        allocSize *= 2;
        String [] newArray = new String[allocSize];
        for (int i=0; i<usedSize; i++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public int size(){
        return usedSize;
    }

    public String get(int index){
        if (index >= usedSize){
            return null;
        }
        return array[index];
    }

    public boolean contains(String str){
        for (int i=0; i<usedSize; i++){
            if (array[i].equals(str)){
                return true;
            }
        }
        return false;
    }
}
