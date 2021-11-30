package PTS_02;

import PTS_02.datatypes.*;

import java.util.HashMap;
import java.util.LinkedList;

public class LinesGenerating implements LinesFactoryInterface{

    private LinkedList<Quadraplet<LineName, LinkedList<Time>, StopName, LinkedList<LineSegmentInterface>>> lines;
    private HashMap<LineName, LinkedList<LineSegment>> lineSegments;
    private StopsInterface stops;

    public LinesGenerating(StopsInterface stops, LinkedList<Quadraplet<LineName, LinkedList<Time>, StopName, LinkedList<LineSegmentInterface>>> lines)
    {
        this.stops = stops;
        lineSegments = new HashMap<>();
        this.lines = lines;
    }
    @Override
    public LineInterface getLineByName(LineName lineName) {
        for (Quadraplet<LineName, LinkedList<Time>, StopName, LinkedList<LineSegmentInterface>> line : lines) {
            if(line.getFirst().equals(lineName))
            {
                return new Line(line.getFirst(), line.getSecond(), line.getThird(), line.getFourth());
            }
        }
        return null;
    }

    public void createSegment(LineName lineName, int index)
    {
        /*for (Quartet<LineName, StopName, Vector<Time>, List<Quintet<TimeDiff, Map<Time, Integer>, Integer, LineName, StopName>>> line : lines) {
            if(line.getValue0().equals(lineName))
            {
                if(lineSegments.get(lineName).get(index) != null) return;

                Quintet<TimeDiff, Map<Time, Integer>, Integer, LineName, StopName> lineSegment = line.getValue3().get(index);
                this.lineSegments.get(lineName).set(index, new LineSegment(lineSegment.getValue0(), lineSegment.getValue1(), lineSegment.getValue2(),lineSegment.getValue3(),new ProxyStop(stops, lineSegment.getValue4())));
            }
        }*/

    }
    @Override
    public void clearBuffer() {
        lineSegments = new HashMap<>();
    }
}
