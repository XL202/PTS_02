package PTS_02;

import java.util.Objects;

public class StopName {
    private String stopName;
    public StopName(String stopName) {
        this.stopName = stopName;
    }

    public String getStopName() {
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
