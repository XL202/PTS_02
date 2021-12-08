package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.FullCapacityException;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class LineSegment implements LineSegmentInterface {

    private final TimeDiff timeToNextStop;
    //private final TimeDiff timeDifferenceFromStart;
    private final StopInterface nextStop;
    private final int capacity;
    private final LineName lineName;
    private final HashMap<Time, Integer> numberOfPassengers;
    private final HashMap<Time, Integer> updatedBusses = new HashMap<>();

    public LineSegment(TimeDiff timeInEndOfSegment, StopInterface nextStop, int capacity, LineName lineName, HashMap<Time, Integer> numberOfPassengers) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative.");
        this.timeToNextStop = timeInEndOfSegment;
        //this.timeDifferenceFromStart = timeDiffFromStart;
        this.nextStop = nextStop;
        this.capacity = capacity;
        this.lineName = lineName;
        this.numberOfPassengers = new HashMap<>(numberOfPassengers);
    }

    @Override
    public Pair<Time, StopName> nextStop(Time startTime) {
        System.out.println("time_inLS: " + startTime.getTime());
        //startTimeOfSegment - returns endSegmentTime
        //System.out.println(numberOfPassengers);
        //
        try {
            if (!numberOfPassengers.containsKey(startTime)) throw new NoSuchElementException("No match for bus at startTime.");
        }
        catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException " + e.getMessage());
        }
        Time time = new Time(timeToNextStop.getTimeDiff() + startTime.getTime());
        return new Pair<>(time, nextStop.getName());
    }

    @Override
    public Triplet<Time, StopName, Boolean> nextStopAndUpdateReachable(Time endTimeOfSegment) {
        System.out.println("StartTimeInNextStop: " + endTimeOfSegment.getTime());
        System.out.println(numberOfPassengers);
        try {
            if (!numberOfPassengers.containsKey(endTimeOfSegment)) throw new NoSuchElementException("No match for bus at startTime.");
            boolean isFree = numberOfPassengers.get(endTimeOfSegment) +1 <= capacity;
            Time time = new Time(timeToNextStop.getTimeDiff() + endTimeOfSegment.getTime());
            System.out.println("nextStop.updateReachableAt(time, lineName): " + nextStop.getName() + " " + time.getTime() + " " + lineName.toString());
            if (isFree) {
                System.out.println(" " + lineName + " " + time);
                nextStop.updateReachableAt(time, lineName);
            }
            return new Triplet<>(time, nextStop.getName(), isFree);
        }
        catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void incrementCapacity(Time endTime) throws FullCapacityException {
        System.out.println("time_in_LS: " + endTime.toString());
        if (!numberOfPassengers.containsKey(endTime)) throw new NoSuchElementException("No match for bus at startTime.");
        if (numberOfPassengers.get(endTime) + 1 > capacity) throw new FullCapacityException();
        numberOfPassengers.put(endTime, numberOfPassengers.get(endTime) + 1);
        updatedBusses.put(endTime, numberOfPassengers.get(endTime));
    }

    public boolean isPossibleToIncrementCapacity(Time endTime) {
        if (!numberOfPassengers.containsKey(endTime)) throw new NoSuchElementException("No match for bus at startTime.");
        return numberOfPassengers.get(endTime) + 1 <= capacity;
    }
    public TimeDiff getTimeToNextStop() {
        return timeToNextStop;
    }
    public HashMap<Time, Integer> getUpdatedBusses() {
        return updatedBusses;
    }
    public String toString() {

        return "[TimeToNextStop: " + timeToNextStop.getTimeDiff() + "; NextStop: " + nextStop.getName() + "; Capacity:" + capacity + "; LineName: " + lineName.toString() + "; NumberOfPassangers: "+ numberOfPassengers + "]\n";
    }
}
