package PTS_02;

import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;

public interface LineInterface {
    void updateReachable(Time time, StopName name);
    void updateCapacityAndGetPreviousStop(StopName name, Time time);
}
