package Exam.Retake.Second;

public class PenguinC implements Penguin{
    private String name;

    public PenguinC(String name){
        this.name = name;
    }

    @Override
    public void Vacc(String station){
        System.out.println(name + " vaccinated by " + station);
    }
}
