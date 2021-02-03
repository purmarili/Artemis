package Exam.Retake.Second;

public class Station extends Thread {
    private final PenguinWaitingQueue wr;

    public Station(PenguinWaitingQueue wr){
        this.wr = wr;
    }

    // 1 point
    public void run(){
        try {
            Penguin p = wr.assign();
        } catch (Exception e) {
            run();
        }
    }

}