package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.Pair;

import java.util.LinkedList;

public interface StopsInterface {
    Pair<StopName, Time> earliestReachableStopAfter(Time time);

    Pair<Time, LineName> getReachableAt(StopName stop);

    LinkedList<LineName> getLines(StopName stop);

    boolean setStartingStop(StopName stop, Time time);

}
