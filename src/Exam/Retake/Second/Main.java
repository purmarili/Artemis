package Exam.Retake.Second;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Vaccination vacc = new Vaccination(5);
        vacc.reserve(new PenguinC("Nika"));
        vacc.reserve(new PenguinC("Levani"));
        vacc.reserve(new PenguinC("Gio"));
        vacc.reserve(new PenguinC("M"));
        vacc.reserve(new PenguinC("N"));
        vacc.reserve(new PenguinC("L"));
    }
}
