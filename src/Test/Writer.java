package Test;

public class Writer extends Thread {
    private int arr [];
    private int n [];
    public Writer(int arr[], int [] n){
        this.arr = arr;
        this.n = n;
    }

    @Override
    public void run(){
        while(true){
            arr[n[0]] = 5;
            System.out.println(this.getName() + " is writing number into array");
            n[0]++;
        }
    }


}
