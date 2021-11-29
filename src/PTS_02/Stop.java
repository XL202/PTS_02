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

    /*public LinkedList<Reachible> getReachible(StopName from) {
        LinkedList<Reachible> tmp = new LinkedList<>();
        return tmp;
    }*/
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
        if (time.compareTo(reachableAt) < 0) {
            reachableAt = time;
            reachableBy = name;
        }
    }
}
