package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.Pair;

import java.util.LinkedList;

public class Stop implements StopInterface{
    private StopName name;
    //private LinkedList<Reachible> reachible;
    private LinkedList<LineName> lines;
    private Time reachableAt = null;
    private LineName reachableBy = null;
    public Stop(StopName name, LinkedList<LineName> lines) {
        this.lines = new LinkedList<>(lines);
        this.name = name;
    }
    @Override
    public StopName getName() {
        return name;
    }

    @Override
    public LinkedList<LineName> getLines() {
        return lines;
    }

    @Override
    public Pair<Time, LineName> getReachableAt() {
        return new Pair<>(reachableAt, reachableBy);
    }

    @Override
    public void updateReachableAt(Time time, LineName name) {
        if (time == null) throw new IllegalArgumentException("Time cannot be null.");
        if (reachableAt == null || time.compareTo(reachableAt) < 0) {

            reachableAt = time;
            reachableBy = name;
            if (name != null) {

                System.out.printf("Stop: '%s' => Time: %s, LineName: %s, reachableAt: %s, reachableBy: %s\n", this.name, time.getTime(), name.toString(), reachableAt.getTime(), reachableBy.toString());
            }

        }
    }
}
