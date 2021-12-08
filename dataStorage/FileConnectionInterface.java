package PTS_02.dataStorage;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.Triplet;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public interface FileConnectionInterface {
    LinkedList<Triplet<StopName, LinkedList<LineName>, LinkedList<Triplet<StopName, Time, LineName>>>> getStopsData(String fileName) throws FileNotFoundException;
}
