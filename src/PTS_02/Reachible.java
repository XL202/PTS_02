package PTS_02;

public class Reachible {
    private StopName from;
    private TimeDiff diff;
    private LineName by;
    public Reachible(StopName from, TimeDiff diff, LineName by) {
        this.from = from;
        this.diff = diff;
        this.by = by;
    }

    public LineName getBy() {
        return by;
    }

    public StopName getFrom() {
        return from;
    }

    public TimeDiff getDiff() {
        return diff;
    }
}
