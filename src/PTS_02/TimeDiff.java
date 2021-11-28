package PTS_02;

import java.util.Objects;

public class TimeDiff {
    private int diff;
    public TimeDiff(int diff) {
        this.diff = diff;
    }
    public int getTimeDiff() {
        return diff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeDiff)) return false;
        TimeDiff timeDiff = (TimeDiff) o;
        return diff == timeDiff.diff;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diff);
    }
}
