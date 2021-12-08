package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.IncorrectUserInputException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stops implements StopsInterface {
    private final StopsFactoryInterface factory;
    private HashMap<StopName, StopInterface> stops = new HashMap<>();

    public Stops(StopsFactoryInterface factory) {
        this.factory = factory;
    }

    @Override
    public boolean setStartingStop(StopName stop, Time time) throws IncorrectUserInputException {
        if (!stops.containsKey(stop)) {
            System.out.println("Stops.notContainsKey(stop): " + stop);
            loadStop(stop);
        }
        System.out.printf("stops.get(stop).update.reachableAt(time,name) [%s,%s,null]\n", stop, time.getTime());
        stops.get(stop).updateReachableAt(time, null);
        return false;
    }
    @Override
    public void loadStop(StopName stop) throws IncorrectUserInputException {
        System.out.printf("loading stop '%s'\n",stop);
        try {
            if (stops.containsKey(stop)) throw new IllegalStateException("Stop has already been loaded.");
            StopInterface newStop = factory.getStopByName(stop);
            try {
                if (newStop == null) throw new IncorrectUserInputException("No such stop in database.");
                System.out.println("loaded stop: " + newStop.getName());
                System.out.println("---------------------------");
                stops.put(stop, newStop);
            }
            catch (IncorrectUserInputException e) {
                System.out.println("IncorrectUserInputException: " + e.getMessage());
            }
        }
        catch (IllegalStateException e) {
            System.out.println("IllegalStateException: " + e.getMessage());
        }


    }
    @Override
    public Pair<LinkedList<StopName>, Time> earliestReachableStopAfter(Time time) {
        Time min = new Time(Long.MAX_VALUE);
        for (StopName stop : stops.keySet()) {
            System.out.println("Stop: " + stop);
            Pair<Time, LineName> data = stops.get(stop).getReachableAt();
            System.out.println(data.getFirst().getTime() + " " + data.getSecond());
            if (data.getFirst().equals(new Time(Long.MAX_VALUE))) continue;

            Time reachable = data.getFirst();
            if (time.compareTo(reachable) < 0) {
                if (reachable.compareTo(min) < 0) min = reachable;
            }
        }

        if (min.equals(new Time(Long.MAX_VALUE))) return null;
        LinkedList<StopName> earliestReachableStops = new LinkedList<>();
        for (StopName stop : stops.keySet()) {
            Pair<Time, LineName> data = stops.get(stop).getReachableAt();
            if (data.getFirst().equals(min)) earliestReachableStops.add(stop);
        }
        System.out.printf("ear: %s, %s \n", earliestReachableStops,min);
        return new Pair<>(earliestReachableStops, min);
    }

    @Override
    public LinkedList<LineName> getLines(StopName stop) throws IncorrectUserInputException {
        if (!stops.containsKey(stop)) loadStop(stop);
        return stops.get(stop).getLines();
    }

    @Override
    public boolean isLoaded(StopName stop) {
        return stops.containsKey(stop);
    }

    @Override
    public StopInterface getStop(StopName stop) throws IncorrectUserInputException {
        if (!stops.containsKey(stop)) loadStop(stop);//throw new NoSuchElementException("Stop has not been loaded yet.");
        return stops.get(stop);
    }

    @Override
    public Pair<Time, LineName> getReachableAt(StopName stop) throws IncorrectUserInputException {
        if (!stops.containsKey(stop)) loadStop(stop);//throw new IllegalStateException("Stop has not been loaded yet.");
        return stops.get(stop).getReachableAt();
    }

    @Override
    public void clean() {
        stops = new HashMap<>();
    }

}
