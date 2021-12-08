package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.FullCapacityException;

import java.util.LinkedList;

public interface LineInterface {
    void updateReachable(Time time, StopName name);
    Triplet<StopName, Time, TimeDiff> updateCapacityAndGetPreviousStop(StopName name, Time time) throws FullCapacityException;
    LinkedList<LineSegmentInterface> getLineSegments();
    LinkedList<Time> getStartTimes();
    LinkedList<StopName> getStopsOnThisLine();
}
