package PTS_02;

import java.util.Objects;

public class LineName {
    private String lineName;
    public LineName(String lineName) {
        this.lineName = lineName;
    }

    public String getStopName() {
        return lineName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StopName)) return false;
        LineName lineName1 = (LineName) o;
        return Objects.equals(lineName, lineName1.lineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineName);
    }
}
