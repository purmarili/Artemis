package Exam.N2.SwimmingPool;
import java.util.*;

public class SwimWaitingQueue {
    private List<Runnable> list;

    public SwimWaitingQueue() {
        this.list = new LinkedList<>();
    }

    public synchronized void enqueue(Runnable r) {
        list.add(r);
    }

    public synchronized Runnable assign() throws InterruptedException {
        while (list.isEmpty()){
            System.out.println("Waiting");
        }
        return list.get(0);
    }
}
