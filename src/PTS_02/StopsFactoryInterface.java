package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.Pair;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.exceptions.IncorrectUserInputException;

import java.util.LinkedList;

public interface StopsFactoryInterface {
    public StopInterface getStopByName(StopName name);
}
