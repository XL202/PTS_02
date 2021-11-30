package PTS_02.dataStorage;

import PTS_02.Stop;
import PTS_02.StopInterface;
import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.TimeDiff;

import java.util.HashMap;
import java.util.LinkedList;

public class DataInMemory {
    long lastDiffFromStart = 0;
    long currentDiffFromStart = 0;
    TimeDiff diff;
    HashMap<Time,Integer> segmentCapacity;
    LinkedList<LineName> lines;
    LinkedList<StopInterface> stops;
    public DataInMemory() {
        stops = new LinkedList<>();
        lines = new LinkedList<>();
        lines.add(createLineNameClass("bus31"));
        //31
        stops.add(new Stop(new StopName("Blumental"), lines));
        lines.add(createLineNameClass("bus93"));
        //31; 93
        stops.add(new Stop(new StopName("Zochova"), lines));
        lines.removeLast();
        //31
        lines.add(createLineNameClass("bus32"));
        //31; 32
        stops.add(new Stop(new StopName("ZOO"), lines));
        lines.removeLast();
        //31
        stops.add(new Stop(new StopName("Slavicie"), lines));
        lines.removeLast();
        //
        lines.add(createLineNameClass("bus32"));
        //32
        stops.add(new Stop(new StopName("Kramare"), lines));
        stops.add(new Stop(new StopName("Botanicka"), lines));
        stops.add(new Stop(new StopName("Dlhe_diely"), lines));
        lines.removeLast();
        //
        lines.add(createLineNameClass("bus93"));
        //93
        stops.add(new Stop(new StopName("Aupark"), lines));
        stops.add(new Stop(new StopName("Petrzalka"), lines));
        lines.removeLast();
        stops.add(new Stop(new StopName("Vysehradska"), lines));
    }
    public LineName createLineNameClass(String lineName) {
        return new LineName(lineName);
    }
}
