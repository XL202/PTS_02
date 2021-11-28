package PTS_02;

import java.util.Objects;

public class Time {
    private int time;
    public Time(int time) {
        this.time = time;
    }
    public int getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;
        Time time1 = (Time) o;
        return getTime() == time1.getTime();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTime());
    }
}
