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

        off();

        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int maxKupiurebi = sc.nextInt();
        int kupiurebiSize = sc.nextInt();
        int [] kupiurebi = new int[kupiurebiSize];
        for (int i=0; i<kupiurebiSize; i++){
            kupiurebi[i] = sc.nextInt();
        }
        Arrays.sort(kupiurebi);
        System.out.println(Arrays.toString(kupiurebi));

        int count = 0, index = 0;
        int a = 5, b = 10;
        System.out.println(Math.min(a, b));
        ArrayList<Integer> lst = new ArrayList<>();
        ArrayList<ArrayList<Integer>> help = new ArrayList<>();
        int min = findMinKupiurebi(price, kupiurebiSize - 1, index, kupiurebi, count, new ArrayList<>(), help);
        if (min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
        int ind = 0, max = 999999;
        for (int i=0; i<help.size(); i++){
            if (help.get(i).size() < max){
                max = help.get(i).size();
                ind = i;
            }
        }
        System.out.println(help.get(ind));
    }
    // 50, 4, 0, [], 0
    // 10 5 20 3
    // 1) 40, 4, 1, [], 1                                                                   2) 50, 4, 1, [], 0
    // 1) 35, 4, 2, [], 2      2) 40, 4, 2, [], 1

    private static int findMinKupiurebi(int price, int kupiurebiSize, int index, int[] kupiurebi, int count, ArrayList<Integer> lst, ArrayList<ArrayList<Integer>> help) {
        if (price == 0){
            System.out.println(lst.toString());
            help.add(lst);
            return count;
        }
        if (price < 0 || index > kupiurebiSize) return Integer.MAX_VALUE;

        ArrayList<Integer> lst1 = new ArrayList<>(lst);
        lst1.add(kupiurebi[index]);
        System.out.println(lst1.toString());
        int with = findMinKupiurebi(price - kupiurebi[index], kupiurebiSize, index+1, kupiurebi,
                count+1, lst1, help);

        ArrayList<Integer> lst2 = new ArrayList<>(lst);

        System.out.println(lst2.toString());
        int without = findMinKupiurebi(price, kupiurebiSize, index+1, kupiurebi, count, lst2, help);

        return Math.min(with, without);
    }


    public static void off(){
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
