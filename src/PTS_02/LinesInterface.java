package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;

import java.util.LinkedList;

public interface LinesInterface {
    void updateReachable(LinkedList<LineName> lines, StopName stop, Time time);
    StopName updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time time);
    void clean();
}
