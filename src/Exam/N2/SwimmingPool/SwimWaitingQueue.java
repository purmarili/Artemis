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

    public synchronized Runnable assign() {
        while (list.isEmpty()){
            System.out.println("waiting");
        }
        return list.get(list.size() - 1);
    }
}
