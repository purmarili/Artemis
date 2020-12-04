package Datik_Class;

public class MyList {

    private int [] arr;
    private int size;
    private int elemCount;

    public MyList(int elemCount){
        this.elemCount = elemCount;
        if (elemCount == 0){
            this.size = 10;
        }else {
            this.size = elemCount * 2;
        }
        arr = new int[size];
    }

    public int get(int index){
        return arr[index];
    }

    public int length(){
        return elemCount;
    }

    public void push_back(int elem){
        if (elemCount == size){
            size *= 2;
            int [] temp = new int[size];
            for (int i=0; i<elemCount; i++){
                temp[i] = arr[i];
            }
            temp[elemCount] = elem;
            arr = temp;
        }else{
            arr[elemCount] = elem;
        }
        elemCount++;
    }



}
