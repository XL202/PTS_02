package PTS_02.datatypes;

import java.util.Objects;

public class TimeDiff {
    private long diff;
    public TimeDiff(long diff) {
            this.diff = diff;
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
