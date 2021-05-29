package Threads;

import java.util.ArrayList;
import java.util.List;

public class Main extends Thread {

    static int[] arr = new int[100];
    static int index = 0;

    public static void main(String[] args) throws InterruptedException {
//        Main[] threads = new Main[100];
//        for (int i = 0; i < 100; i++) {
//            threads[i] = new Main();
//        }
//        for (int i = 0; i < 100; i++) {
//            threads[i].start();
//        }
//        threads[5].join();
//        for (int i = 0; i < 100; i++) arr[i] = i;
//        Main first = new Main();
//        Main second = new Main();
//        first.start();
//        second.start();
//
//        first.join();
//        second.join();

        System.out.println("This code is outside of the thread");
    }

    @Override
    public void run() {
        while (index < 100) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + arr[index]);
            index++;
        }


//        for (int i=0; i<10; i++)
//            System.out.println(Thread.currentThread().getName() + " is working " + i);
    }
}