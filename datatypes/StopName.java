package PTS_02.datatypes;

import java.util.Objects;

public class StopName {
    private String stopName;
    public StopName(String stopName) {
        if (stopName == null) throw new IllegalArgumentException("Name cannot be null.");
        this.stopName = stopName;
    }
    @Override
    public String toString() {
        return stopName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StopName)) return false;
        StopName stopName1 = (StopName) o;
        return Objects.equals(stopName, stopName1.stopName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopName);
    }
}
