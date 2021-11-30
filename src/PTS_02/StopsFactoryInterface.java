package PTS_02;

import PTS_02.datatypes.StopName;

public interface StopsFactoryInterface {
    StopInterface getStopByName(StopName name);
}
