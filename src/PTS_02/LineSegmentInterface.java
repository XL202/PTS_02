package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.FullCapacityException;

import java.util.HashMap;

public interface LineSegmentInterface {
    Pair<Time, StopName> nextStop(Time startTime);
    Triplet<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime);
    void incrementCapacity(Time startTime) throws FullCapacityException;
    TimeDiff getTimeToNextStop();
    HashMap<Time, Integer> getUpdatedBusses();
}
