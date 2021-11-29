package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;

import java.util.LinkedList;

public class Line implements LineInterface {
    private LineName lineName;
    private LinkedList<Time> startTimes;
    private StopName startStop;
    public Line(LineName lineName, LinkedList<Time> startTimes, StopName startStop) {
        this.startTimes = new LinkedList<>(startTimes);
        this.lineName = lineName;
        this.startStop = startStop;
    }


    @Override
    public void updateReachable(Time time, StopName name) {

    }

    @Override
    public void updateCapacityAndGetPreviousStop(StopName name, Time time) {

    }
}
