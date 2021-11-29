package PTS_02.datatypes;

import java.util.Objects;

public class Quadraplet<T1, T2, T3, T4> {
    private final T1 first;
    private final T2 second;
    private final T3 third;
    private final T4 fourth;

    public Quadraplet(T1 first, T2 second, T3 third, T4 fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public T3 getThird() {
        return third;
    }

    public T4 getFourth() {
        return fourth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadraplet<?, ?, ?, ?> quadraplet = (Quadraplet<?, ?, ?, ?>) o;
        return Objects.equals(first, quadraplet.first) && Objects.equals(second, quadraplet.second) && Objects.equals(third, quadraplet.third) && Objects.equals(fourth, quadraplet.fourth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }
}
