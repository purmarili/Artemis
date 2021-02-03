package Exam.Retake.Third;

import java.util.function.*;
import java.util.stream.*;

public interface Succ<T> {
    Succ<T> succ(T t);

    static <T> BiFunction<Succ<T>, T, Succ<T>> export() {
        return (a, b) -> a.succ(b);
    }

    default boolean looping(T t) {
        return this == succ(t);
    }

    default Succ<T> nullify() {
        return (t) -> {
            if (t == null) return null;
            if (this == succ(t)) return null;
            return succ(t);
        };
    }

    default Succ<T> filter(Predicate<? super T> p) {
        return null;
    }

    default Succ<T> succ(Stream<T> s) {
        return null; // TODO
    }
}


