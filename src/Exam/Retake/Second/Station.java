package Exam.Retake.Second;

public class Station extends Thread {
    private final PenguinWaitingQueue wr;
    private String name;

    public Station(PenguinWaitingQueue wr, String name){
        this.name = name;
        this.wr = wr;
    }

    // 1 point
    public void run(){
        try {
            Penguin p = wr.assign();
            p.Vacc(name);
        } catch (Exception e) {
            run();
        }
    }

}