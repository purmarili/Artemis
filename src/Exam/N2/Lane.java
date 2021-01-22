package Exam.N2;

public class Lane extends Thread {
    private SwimWaitingQueue tasks = null;

    public Lane(SwimWaitingQueue wr) {
        tasks = wr;
    }

    public void run() {
        try {
            if (isInterrupted())
                return;
            Runnable swimmer = tasks.assign();
        } catch (Exception e){
            run();
        }
        interrupt();
    }

    public synchronized void doStop() {
        interrupt();
    }


    // perhaps aux. methods



}
