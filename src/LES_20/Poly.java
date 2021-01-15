package LES_20;

public class Poly {
    static class A {
        int x() {
            return 0;
        }

        int y = 3;

        static void f(A a) {
            System.out.print(a.x() + "-");
            a.g(a);
        }

        static void f(B b) {
            System.out.print(b.y + "-");
            b.g(b);
        }

        void g(A a) {
            System.out.println(a.y);
        }

        void g(B b) {
            System.out.print(b.y + "-");
            this.f(this);
        }
    }

    static class B extends A {
        int x() {
            return 1;
        }

        int y = 9;

        static void f(A a) {
            System.out.print(a.y + "-");
            (new A()).g(a);
        }

        static void f(B b) {
            System.out.print(b.y + "-");
            ((B) b).f((A) b);
        }

        void g(A a) {
            System.out.print(a.y + "-");
            a.f((B) a);
        }

        void g(B b) {
            System.out.print(b.x() + "-");
            b.f(b);
        }
    }

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();

        b.f(b); // call 1  "9-3-3"
        a1.g(b); // call 2  "9-0-
//        a2.f(b); // call 3
//        a2.g(a1); // call 4
//        a2.f(a2); // call 5
    }
}