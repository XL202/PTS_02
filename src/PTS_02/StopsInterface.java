package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.Pair;
import PTS_02.exceptions.IncorrectUserInputException;

import java.util.LinkedList;

public interface StopsInterface {
    Pair<LinkedList<StopName>, Time> earliestReachableStopAfter(Time time);

    boolean setStartingStop(StopName stop, Time time) throws IncorrectUserInputException;

    LinkedList<LineName> getLines(StopName stop) throws IncorrectUserInputException;

    void loadStop(StopName stop) throws IncorrectUserInputException;

    boolean isLoaded(StopName stop);

    StopInterface getStop(StopName stop) throws IncorrectUserInputException;

    Pair<Time, LineName> getReachableAt(StopName stop) throws IncorrectUserInputException;

    void clean();

}
