package PTS_02;

import PTS_02.datatypes.LineName;

public interface LinesFactoryInterface {
    LineInterface getLineByName(LineName lineName);
    void createSegment(LineName lineName, int index);
    void clearBuffer();
}
