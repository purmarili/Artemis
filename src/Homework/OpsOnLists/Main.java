package Homework.OpsOnLists;

public class Main {
    public static void main(String[] args) {
        IntDoubleList lst = new IntDoubleList();
        lst.append(1);
        lst.append(4);
        lst.append(3);
        lst.append(2);
        lst.append(5);
        lst.append(2);
        System.out.println(OpsOnLists.partTheList(lst, 3).toString());
    }
}
