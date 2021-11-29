package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.FullCapacityException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class LineSegment implements LineSegmentInterface {

    private final TimeDiff timeToNextStop;
    //private final TimeDiff timeDifferenceFromStart;
    private final StopInterface nextStop;
    private final int capacity;
    private final LineName lineName;
    private final Map<Time, Integer> numberOfPassengers;
    private final HashMap<Time, Integer> updatedBusses = new HashMap<>();
    private final int segmentIndex;

    public LineSegment(TimeDiff timeToNextStop, StopInterface nextStop, int capacity, LineName lineName, HashMap<Time, Integer> numberOfPassengers, int segmentIndex) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative.");
        this.timeToNextStop = timeToNextStop;
        //this.timeDifferenceFromStart = timeDiffFromStart;
        this.nextStop = nextStop;
        this.capacity = capacity;
        this.lineName = lineName;
        this.numberOfPassengers = new HashMap<>(numberOfPassengers);
        this.segmentIndex = segmentIndex;
    }

    @Override
    public Pair<Time, StopName> nextStop(Time startTime) {
        if (!numberOfPassengers.containsKey(startTime)) throw new NoSuchElementException("No match for bus at startTime.");
        Time time = new Time(timeToNextStop.getTimeDiff() + startTime.getTime());
        return new Pair<>(time, nextStop.getName());
    }

    @Override
    public Triplet<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime) {
        if (!numberOfPassengers.containsKey(startTime)) throw new NoSuchElementException("No match for bus at startTime.");
        boolean isFree = numberOfPassengers.get(startTime) +1 <= capacity;
        Time time = new Time(timeToNextStop.getTimeDiff() + startTime.getTime());
        if (isFree) nextStop.updateReachableAt(time, lineName);
        return new Triplet<>(time, nextStop.getName(), isFree);
    }

    @Override
    public void incrementCapacity(Time startTime) throws FullCapacityException {
        if (!numberOfPassengers.containsKey(startTime)) throw new NoSuchElementException("No match for bus at startTime.");
        if (numberOfPassengers.get(startTime) + 1 > capacity) throw new FullCapacityException();
        numberOfPassengers.put(startTime, numberOfPassengers.get(startTime) + 1);
        updatedBusses.put(startTime, numberOfPassengers.get(startTime));
    }

    public TimeDiff getTimeToNextStop() {
        return timeToNextStop;
    }
    public HashMap<Time, Integer> getUpdatedSegments() {
        return updatedBusses;
    }
}
