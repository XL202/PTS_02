package PTS_02;

import PTS_02.datatypes.LineName;

import java.io.FileNotFoundException;

public interface LinesFactoryInterface {
    LineInterface getLineByName(LineName lineName) throws FileNotFoundException;
    void createSegment(LineName lineName, int index);
    void clearBuffer();
}
