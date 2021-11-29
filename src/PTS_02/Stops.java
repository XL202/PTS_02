package PTS_02;

import PTS_02.datatypes.*;

import java.util.LinkedList;

public class Stops implements StopsInterface {

    @Override
    public Pair<StopName,Time> earliestReachableStopAfter(Time time) {
        Pair<StopName,Time> tmp = new Pair<>(new StopName("abc"), new Time(123));
        return tmp;
    }
    @Override
    public Pair<Time,LineName> getReachableAt(StopName stop) {
        Pair<Time, LineName> tmp = new Pair<>(new Time(1), new LineName("bdc"));
        return tmp;
    }
    @Override
    public LinkedList<LineName> getLines(StopName stop) {
        LinkedList<LineName> tmp = new LinkedList<>();
        return tmp;
    }
    @Override
    public boolean setStartingStop(StopName stop, Time time) {
        return false;
    }

}
