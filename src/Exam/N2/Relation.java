package Exam.N2;
import java.util.function.Function;

public interface Relation<X,Y> {

    boolean test(X x, Y y);

    default Relation<X,Y> negate() {
        return (first, sec) -> {
            boolean p = test(first, sec);
            return !p;
        };
    }

    default Relation<X, Y> mirror() {
        return (first, sec) ->{
            boolean p = test(first, sec);
            return p;
        };
    }

    default Relation<X,Y> and(Relation<X, Y> other) {
        return (first, sec) -> {
            boolean p = test(first, sec);
            boolean k = other.test(first, sec);
            return p && k;
        };
    }

    default <Z> Relation<Z,Y> compose(Function<Z, Y> f) {
//        return (x, y) -> test(f.apply(x), y);
        return null;
    }
}
