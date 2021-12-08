package PTS_02.datatypes;

import java.util.Objects;

public class TimeDiff {
    private long diff;
    public TimeDiff(long diff) {
        if (diff < 0) throw new IllegalArgumentException("TimeDiff cannot be negative.");
        this.diff = diff;
    }
    public TimeDiff(long time1, long time2) {
        if (time1 < 0) throw new IllegalArgumentException("Time cannot be negative.");
        if (time2 < 0) throw new IllegalArgumentException("Time cannot be negative.");
        if (time1 - time2 < 0) throw new IllegalArgumentException("TimeDiff cannot be negative.");
        diff = time1 - time2;
    }
    public long getTimeDiff() {
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
