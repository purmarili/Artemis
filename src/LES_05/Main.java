package LES_05;

public class Main {
    public static void main(String[] args) {

        IntDoubleList list = new IntDoubleList();


        list.append(5);

        list.append(10);

        list.append(15);

        list.append(20);

        System.out.println(list.get(1));

        list.remove(1);
        System.out.println(list.get(1));
        System.out.println(list.get(3));

    }
}
