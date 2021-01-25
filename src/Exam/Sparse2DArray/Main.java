package Exam.Sparse2DArray;

public class Main {
    public static void main(String[] args) {
        Sparse2DArray<String> sp = new Sparse2DArray<>(5, 5);
        sp.set(1, 4, "Hello");
        sp.set(1, 3, "erti");
        sp.set(2, 3, "N");
        sp.set(0, 2, "Gello");
        sp.sortElemenets();
        System.out.println(sp.toString());
    }
}
