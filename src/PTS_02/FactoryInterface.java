package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;

import java.util.LinkedList;

public interface FactoryInterface {

    void setStops(StopsInterface stops);

    StopInterface createStop(StopName stopName);

    LineInterface createLine(LineName lineName, Time time);

    void updateDatabase(LinkedList<LineSegmentInterface> lineSegments);

}