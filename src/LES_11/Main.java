package LES_11;

import LES_08_09.AIRobot;
import LES_08_09.Robot;
import LES_08_09.SuperRobot;
import LES_12.Penguin;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int maxKupiurebi = sc.nextInt();
        int kupiurebiSize = sc.nextInt();
        int [] kupiurebi = new int[kupiurebiSize];
        for (int i=0; i<kupiurebiSize; i++){
            kupiurebi[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(kupiurebi));

        int count = 0, index = 0;

        int min = findMinKupiurebi(price, kupiurebiSize - 1, index, kupiurebi, maxKupiurebi, count);
        if (min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }


    private static int findMinKupiurebi(int price, int kupiurebiSize, int index, int[] kupiurebi, int maxKupiurebi, int count) {
        if (price == 0) return count;
        if (price < 0) return Integer.MAX_VALUE;
        if (index > kupiurebiSize) return Integer.MAX_VALUE;

        int with = findMinKupiurebi(price - kupiurebi[index], kupiurebiSize, index+1, kupiurebi, maxKupiurebi-1, count+1),
            without = findMinKupiurebi(price, kupiurebiSize, index+1, kupiurebi, maxKupiurebi-1, count);
        return Math.min(with, without);
    }


    private void off(){
        OurArrayList<String> k = new OurArrayList<>();
        k.add("gasd");
        k.add("gasd");
        k.add("gasd");
        k.add("gasd");
        k.add("gasd");
        k.add("gasd");
        k.add("gasd");
        k.add("gasd");
        k.add("gasd");


        OurArrayList<String> a = new OurArrayList<>();
        a.add("gkjsgds");
        a.add("gkjsgds");
        a.add("gkjsgds");

        OurArrayList<String> b = new OurArrayList<>();
        b.add("sd");
        b.add("sd");

        System.out.println(OurArrayList.getStaticSize());

        System.out.println();
        System.out.println();

        OurArrayList<String> lst = new OurArrayList<>();
        lst.add("Hello");
        lst.add("HI");
        System.out.println(lst.get(0));
        System.out.println(lst.get(1));
        System.out.println(lst.contains("HI"));
        lst.delete(1);
        for (int i=0; i<lst.size(); i++){
            System.out.println(lst.get(i));
        }

        Robot robot = new Robot();
        Robot superRobot = new SuperRobot();
        AIRobot aiRobot = new AIRobot();
        ArrayList<Robot> ar = new ArrayList<>();

        Predicate<? super AIRobot> isBlue = new Predicate<SuperRobot>() {
            @Override
            public boolean test(SuperRobot robot) {
                return robot.getAge() > 100 && robot.getColor() != "Black" && robot.getName() != "SHAWN";
            }
        };
        Predicate<? super AIRobot> hello = new Predicate<SuperRobot>() {
            @Override
            public boolean test(SuperRobot robot) {
                return robot.getAge() > 100 && robot.getColor() != "Black" && robot.getName() != "SHAWN";
            }
        };
//
//        for (int i=0; i<Penguins.size(); i++){
//            if (isBlue.test(Penguins.get(i)).and().or){
//                Penguins.remove(i);
//            }
//        }

        if (isBlue.test(aiRobot)){
            System.out.println("is Blue");
        }
    }

    ArrayList<Penguin> penguins;

    void splitColony(Predicate<? super Penguin> pred){

        for (int i=0; i<penguins.size(); i++) {
            if (pred.test(penguins.get(i))) {
                penguins.remove(i);
            }
        }

    }
}
