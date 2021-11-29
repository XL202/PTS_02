package PTS_02;

import PTS_02.datatypes.Pair;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.Triplet;

public class LineSegment implements LineSegmentInterface{
    @Override
    public Pair<Time, StopName> nextStop(Time startTime) {
        return null;
    }

    @Override
    public Triplet<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime) {
        return null;
    }

    @Override
    public void incrementCapacity(Time startTime) {

    }
}
