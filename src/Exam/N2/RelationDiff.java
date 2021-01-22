package Exam.N2;

import java.util.function.Function;

public interface RelationDiff<X,Y> {

    boolean test(X x, Y y);

    default Relation<X,Y> negate() {
        return (x,y) -> !test(x,y);
    }

    default Relation<? super Y , ? super X> mirror() {
        return (x,y) -> test(y,x);
    }

    default Relation<X,Y> and(Relation<? super X, ? super Y> other) {
        return (x,y) -> test(x,y) && other.test(x,y);
    }

    default <Z> Relation<Z,Y> compose(Function<? super Z , ? super Y > f) {
        return (z,y) -> test((X) f.apply(z), y);
    }
}