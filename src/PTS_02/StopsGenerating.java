package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.Pair;
import PTS_02.datatypes.StopName;

import java.util.LinkedList;

public class StopsGenerating implements StopsFactoryInterface{
    private LinkedList<Pair<StopName, LinkedList<LineName>>> stops;

    public StopsGenerating(LinkedList<Pair<StopName, LinkedList<LineName>>> stops) {
        this.stops = stops;
    }

    @Override
    public StopInterface getStopByName(StopName stopName)
    {
        for (Pair<StopName, LinkedList<LineName>> stop : stops) {
            if (stop.getFirst().equals(stopName))
            {
                return new Stop(stop.getFirst(), stop.getSecond());
            }
        }
        return null;
    }
}
