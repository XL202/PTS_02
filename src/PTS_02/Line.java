package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.FullCapacityException;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Line implements LineInterface {
    private LineName lineName;
    private LinkedList<Time> startTimes;
    private StopName startStop;
    private LinkedList<LineSegmentInterface> lineSegments;
    public Line(LineName lineName, LinkedList<Time> startTimes, StopName startStop, LinkedList<LineSegmentInterface> lineSegments) {
        if (startTimes.size() == 0) throw new IllegalArgumentException("Line must have at least one bus.");
        if (lineSegments.size() == 0) throw new IllegalArgumentException("Line must have at least one segment.");
        this.startTimes = new LinkedList<>(startTimes);
        this.lineName = lineName;
        this.startStop = startStop;
        this.lineSegments = new LinkedList<>(lineSegments);
    }


    @Override
    public void updateReachable(Time time, StopName name) {

    }

    @Override
    public StopName updateCapacityAndGetPreviousStop(StopName name, Time time) throws FullCapacityException {
        if (name.equals(startStop)) throw new NoSuchElementException("Entered stop is first stop!");
        StopName previousStop = startStop;
        for(int i=0; i<startTimes.size(); i++) {
            for(int j=0; j<lineSegments.size(); j++) {
                Pair<Time, StopName> tmp = lineSegments.get(j).nextStop(startTimes.get(i));
                if (tmp.getSecond() == name) {
                    lineSegments.get(j).incrementCapacity(startTimes.get(i));
                    return previousStop;
                }
                else {
                    previousStop = tmp.getSecond();
                }
            }
        }
        return null;
    }

    public LinkedList<LineSegmentInterface> getLineSegments() {
        return lineSegments;
    }
}
