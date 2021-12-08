package PTS_02.datatypes;

import java.util.Objects;

public class Time implements Comparable<Time> {
    private final long time;
    public Time(long time) {
        if (time < 0) throw new IllegalArgumentException("Time cannot be negative.");
        this.time = time;
    }
    public long getTime() {
        return time;
    }
    public String toString() {
        return Long.toString(time);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time time1)) return false;
        return getTime() == time1.getTime();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime());
    }

    @Override
    public int compareTo(Time o) {
        return Long.compareUnsigned(this.time, o.time);
    }


}
