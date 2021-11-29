package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.Pair;

import java.util.LinkedList;

public interface StopInterface {
    LinkedList<LineName> getLines();
    Pair<Time, LineName> getReachableAt();
    void updateReachibleAt(Time time, LineName name);
}
