package PTS_02;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Line {
    private LineName lineName;
    private LinkedList<Time> startTimes;
    private StopName startStop;
    public Line(LineName lineName, LinkedList<Time> startTimes, StopName startStop) {
        this.startTimes = new LinkedList<>(startTimes);
        this.lineName = lineName;
        this.startStop = startStop;
    }


}
