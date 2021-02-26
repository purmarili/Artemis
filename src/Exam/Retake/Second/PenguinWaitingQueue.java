package Exam.Retake.Second;

import java.util.LinkedList;
import java.util.List;

public class PenguinWaitingQueue {
    private List<Penguin> list;

    public PenguinWaitingQueue() {
        list = new LinkedList<>();
    }

    public synchronized void enqueue(Penguin r) {
        list.add(r);
    }

    public synchronized Penguin assign() throws InterruptedException {
        while (list.size() == 0){
            System.out.println("Waiting");
        }
        return list.remove(0);
    }
}

