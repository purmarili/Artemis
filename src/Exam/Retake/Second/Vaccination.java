package Exam.Retake.Second;

public class Vaccination {
    private PenguinWaitingQueue tasks;
    private Station[] threads;

    public Vaccination(int threadCount){
        tasks = new PenguinWaitingQueue();
        threads = new Station[threadCount];
        for (int i=0; i<threadCount; i++){
            threads[i].start();
        }
    }

    public synchronized void reserve(Penguin p) throws Exception {
        tasks.enqueue(p);
    }
}
