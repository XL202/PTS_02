package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.FullCapacityException;
import PTS_02.exceptions.IncorrectUserInputException;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public interface LinesInterface {
    void updateReachable(LinkedList<LineName> lines, StopName stop, Time time) throws IncorrectUserInputException, FileNotFoundException;
    Triplet<StopName, Time, TimeDiff> updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time time) throws FullCapacityException, IncorrectUserInputException, FileNotFoundException;
    void clean();
    void updateSegment(LineName lineName, int index);
    public void saveUpdatedLineSegments();
}
