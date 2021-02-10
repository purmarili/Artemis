package Exam.Retake.Second;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PenguinWaitingQueue pq = new PenguinWaitingQueue();
        pq.enqueue(new Penguin() {
            @Override
            public void vacc() throws Exception {
                System.out.println("vaccinated");
            }
        });
    }
}
