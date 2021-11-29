package PTS_02;

import PTS_02.datatypes.Pair;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.Triplet;

public interface LineSegmentInterface {
    Pair<Time, StopName> nextStop(Time startTime);
    Triplet<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime);
    void incrementCapacity(Time startTime);
}
