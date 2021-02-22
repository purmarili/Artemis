package Threads;

import Test.Threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReaderWriter {
    public static void main(String[] args) throws InterruptedException {
        List<String> temp = new ArrayList<>();
        List<String> list = Collections.synchronizedList(temp);

        for (int i = 0; i < 5000; i++) {
            list.add(i, "" + i);
        }

        // The 5 readers query 10000 times the  [1-5]000th value
        Thread[] readers = new Thread[5];
        for (int i = 0; i < readers.length; i++) {
            final int icopy = i * 1000;

            readers[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    list.get(icopy);
                }
            });

        }
        // the writer inserts 10000 times an element and subsequently deletes it again
        Thread writer = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                list.add(4, "4");
                list.remove(4);
            }
        });

        // We now start all and measure how long they run
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < readers.length; i++)
            readers[i].start();
        writer.start();
        for (int i = 0; i < readers.length; i++)
            readers[i].join();
        writer.join();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Duration: " + (duration) + "ms");
    }
}
