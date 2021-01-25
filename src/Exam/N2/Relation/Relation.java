package Exam.N2.Relation;
import java.util.function.Function;

public interface Relation<X,Y> {

    boolean test(X x, Y y);


    default Relation<X,Y> negate() {
        return (x,y) -> !test(x, y);
    }

    default Relation<X,Y> mirror() {
        return (x, y) -> test((X)y, (Y)x);
    }

    default Relation<X,Y> and(Relation<? super X, ? super Y> other) {
        return (x, y) -> test(x, y) == other.test(x, y);
    }

    default <Z> Relation<Z,Y> compose(Function<Z, X> f) {
        return (z, y) -> test(f.apply(z), y);
    }
}
