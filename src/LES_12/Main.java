package LES_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {


        List<String> lst = new ArrayList<>();

        Penguin p = new Penguin();
        Elephant e = new Elephant();
        Robot<Penguin> ro = new Robot(5, "gasd", "Ge", p);
        Robot robot = new Robot(e);
    }
}
