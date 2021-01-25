package Exam.N2.SwimmingPool;
import java.util.*;

public class SwimmingPool {
    private SwimWaitingQueue tasks = null;
    private List<Lane> threads = new ArrayList<>();



    public SwimmingPool(int threadCount){
        tasks = new SwimWaitingQueue();
        for (int i=0; i<threadCount; i++){
            Lane l = new Lane(tasks);
            threads.add(l);
        }
        for (Lane thread : threads) {
            thread.start();
        }
    }

    public synchronized void  reserve(Runnable task) throws Exception {
        tasks.enqueue(task);
    }

    public synchronized void stop(){
        for (Lane l : threads)
            l.doStop();
    }
}
