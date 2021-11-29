package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;

import java.util.LinkedList;

public class Lines implements LinesInterface{
    @Override
    public void updateReachable(LinkedList<LineName> lines, StopName stop, Time time) {

    }

    @Override
    public StopName updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time time) {
        return null;
    }

    @Override
    public void clean() {

    }
}
