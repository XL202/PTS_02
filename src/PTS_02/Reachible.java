package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;

public class Reachible {
    private StopName from;
    private Time.TimeDiff diff;
    private LineName by;
    public Reachible(StopName from, Time.TimeDiff diff, LineName by) {
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

    public Time.TimeDiff getDiff() {
        return diff;
    }
}
