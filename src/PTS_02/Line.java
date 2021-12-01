package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.FullCapacityException;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

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


    public void updateReachable(Time time, StopName stopName)
    {
        StopName nextStop = startStop;
        Time tmp = startTimes.get(0);
        int startingLineSegmentIndex = 0;
        for (int i = 0; !Objects.equals(nextStop, stopName); i++) {
            if (i >= lineSegments.size()) throw new NoSuchElementException("No such stop in lineSegments");
            Pair<Time, StopName> data = lineSegments.get(i).nextStop(tmp);
            tmp = data.getFirst();
            nextStop = data.getSecond();
            startingLineSegmentIndex++;
        }
        TimeDiff totalTimeDiff = new TimeDiff(tmp.getTime() - startTimes.get(0).getTime());

        //determine the earliest catchable bus at starting lineSegment
        Time earliestCatchable = new Time(startTimes.get(0).getTime() + totalTimeDiff.getTimeDiff());
        int earliestCatchableIndex = 0;
        for (int i=1; earliestCatchable.compareTo(time) < 0; i++) {
            if (i >= startTimes.size()) return;
            earliestCatchable = new Time(startTimes.get(i).getTime() + totalTimeDiff.getTimeDiff());
            earliestCatchableIndex++;
        }

        //update reachable stops from starting lineSegment
        while (startingLineSegmentIndex < lineSegments.size()) {
            Triplet<Time, StopName, Boolean> data = lineSegments.get(startingLineSegmentIndex).nextStopAndUpdateReachable(earliestCatchable);
            if (!data.getThird()) {
                earliestCatchableIndex++;
                if (earliestCatchableIndex >= startTimes.size()) return;
                TimeDiff waitForNextBus = new TimeDiff(startTimes.get(earliestCatchableIndex).getTime() - startTimes.get(earliestCatchableIndex-1).getTime());
                earliestCatchable = new Time(earliestCatchable.getTime() + waitForNextBus.getTimeDiff());
                continue;
            }
            earliestCatchable = data.getFirst();
            startingLineSegmentIndex++;
        }
    }

    @Override
    public StopName updateCapacityAndGetPreviousStop(StopName name, Time time) throws FullCapacityException {
      /*  if (name.equals(startStop)) throw new NoSuchElementException("Entered stop is first stop!");
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
        }*/
        return null;
    }
    @Override
    public LinkedList<LineSegmentInterface> getLineSegments() {
        return lineSegments;
    }
}
