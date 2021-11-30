package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.exceptions.FullCapacityException;

public interface LineInterface {
    void updateReachable(Time time, StopName name);
    StopName updateCapacityAndGetPreviousStop(StopName name, Time time) throws FullCapacityException;

}
