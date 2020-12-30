package Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {
    public static void main(String[] args) {
//
//        Lock lock = new ReentrantLock();
//        Condition cond = lock.newCondition();

        int arr[] = new int[5];
        int n[] = new int[1];

        Writer writer = new Writer(arr, n);
        Writer writer1 = new Writer(arr, n);

        writer.start();
        writer1.start();


    }
}

