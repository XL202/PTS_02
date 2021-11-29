package PTS_02.datatypes;

import java.util.Objects;

public class LineName {
    private String lineName;
    public LineName(String lineName) {
        if (lineName == null) throw new IllegalArgumentException("Name cannot be null.");
        this.lineName = lineName;
    }
    @Override
    public String toString() {
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
