package LES_11;

import LES_08_09.AIRobot;
import LES_08_09.Robot;
import LES_08_09.SuperRobot;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

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


        // Predicate
        Predicate<? super Robot> isBlue = new Predicate<Robot>() {
            @Override
            public boolean test(Robot s) {
                if (s.getColor().equals("BLACK"))
                    return true;
                return false;
            }
        };
        if (isBlue.test(robot)){
            System.out.println("is Blue");
        }
    }
}
