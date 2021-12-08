package PTS_02.dataStorage;

import PTS_02.*;
import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.TimeDiff;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;

public class DataInMemory implements StopsFactoryInterface, LinesFactoryInterface{
    HashMap<Time,Integer> currentCapacity;
    LinkedList<LineName> lines;
    LinkedList<Line> linesWithSegments = new LinkedList<>();
    LinkedList<StopInterface> stops;
    public DataInMemory() {
        /*
        stops with their lines (which starts from stops)
         */
        LinkedList<StopName> stopsName;
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


        lines.add(createLineNameClass("bus31"));
        lines.add(createLineNameClass("bus32"));
        lines.add(createLineNameClass("bus93"));

        //line31 segments start
        //first is startStop
        StopName startStop;
        StopInterface nextStop;
        LinkedList<LineSegmentInterface> segments = new LinkedList<>();
        stopsName = new LinkedList<>();
        stopsName.add(new StopName("Blumental"));
        stopsName.add(new StopName("Zochova"));
        stopsName.add(new StopName("ZOO"));
        stopsName.add(new StopName("Slavicie"));
        startStop = new StopName("Blumental");
        LinkedList<Time> times = new LinkedList<>();

        times.add(new Time(0));
        times.add(new Time(10));
        times.add(new Time(20));
        times.add(new Time(30));
        times.add(new Time(40));
        {


            nextStop = getStopByName("Zochova");
            segments.add(new LineSegment(new TimeDiff(5), nextStop, 3, createLineNameClass("Zochova"), currentCapacity));

            nextStop = getStopByName("ZOO");
            segments.add(new LineSegment(new TimeDiff(8), nextStop, 3, createLineNameClass("ZOO"), currentCapacity));

            nextStop = getStopByName("Slavicie");
            segments.add(new LineSegment(new TimeDiff(2), nextStop, 3, createLineNameClass("Slavicie"), currentCapacity));
        }
        linesWithSegments.add(new Line(createLineNameClass("bus31"), times, startStop, segments, stopsName));
        //line31 to segments end

        //line32 segments start
        //first is startStop
        segments = new LinkedList<>();
        stopsName = new LinkedList<>();
        stopsName.add(new StopName("Hl.st."));
        stopsName.add(new StopName("Kramare"));
        stopsName.add(new StopName("ZOO"));
        stopsName.add(new StopName("Botanicka"));
        stopsName.add(new StopName("DlheDiely"));
        startStop = new StopName("Hl.st.");
        times = new LinkedList<>();

        times.add(new Time(3));
        times.add(new Time(23));
        times.add(new Time(43));
        times.add(new Time(63));
        {
            nextStop = getStopByName("Kramare");
            currentCapacity = new HashMap<>();
            for (int i = 0; i < times.size(); i++) {
                currentCapacity.put(times.get(i), 0);
            }
            segments.add(new LineSegment(new TimeDiff(6), nextStop, 3, createLineNameClass("Kramare"), currentCapacity));

            nextStop = getStopByName("ZOO");
            segments.add(new LineSegment(new TimeDiff(5), nextStop, 3, createLineNameClass("ZOO"), currentCapacity));

            nextStop = getStopByName("Botanicka");
            segments.add(new LineSegment(new TimeDiff(2), nextStop, 3, createLineNameClass("Botanicka"), currentCapacity));

            nextStop = getStopByName("DlheDiely");
            segments.add(new LineSegment(new TimeDiff(9), nextStop, 3, createLineNameClass("Dlhe_diely"), currentCapacity));

        }
        linesWithSegments.add(new Line(createLineNameClass("bus32"), times, startStop, segments, stopsName));
        //line32 to segments end

        //line93 segments start
        //first is startStop
        segments = new LinkedList<>();
        stopsName = new LinkedList<>();
        stopsName.add(new StopName("Hl.st."));
        stopsName.add(new StopName("Zochova"));
        stopsName.add(new StopName("Aupark"));
        stopsName.add(new StopName("Petrzalka"));
        stopsName.add(new StopName("Vysehradska"));
        startStop = new StopName("Hl.st.");
        times = new LinkedList<>();

        times.add(new Time(2));
        times.add(new Time(7));
        times.add(new Time(12));
        times.add(new Time(17));
        times.add(new Time(22));
        times.add(new Time(27));
        {
            nextStop = getStopByName("Zochova");
            currentCapacity = new HashMap<>();
            for (int i = 0; i < times.size(); i++) {
                currentCapacity.put(times.get(i), 0);
            }
            segments.add(new LineSegment(new TimeDiff(5), nextStop, 3, createLineNameClass("Zochova"), currentCapacity));

            nextStop = getStopByName("Aupark");
            segments.add(new LineSegment(new TimeDiff(2), nextStop, 3, createLineNameClass("Aupark"), currentCapacity));

            nextStop = getStopByName("Petrzalka");
            segments.add(new LineSegment(new TimeDiff(3), nextStop, 3, createLineNameClass("Petrzalka"), currentCapacity));

            nextStop = getStopByName("Vysehradska");
            segments.add(new LineSegment(new TimeDiff(9), nextStop, 3, createLineNameClass("Vysehradska"), currentCapacity));

        }
        linesWithSegments.add(new Line(createLineNameClass("bus93"), times, startStop, segments, stopsName));
        //line93 to segments end
    }
    public LineName createLineNameClass(String lineName) {
        return new LineName(lineName);
    }
    public StopInterface getStopByName(String name) {
        for (int i = 0; i < stops.size(); i++) {
            if (stops.get(i).getName().toString().equals(name)) return stops.get(i);
        }
        return null;
    }


    @Override
    public LineInterface getLineByName(LineName lineName) {
        for (int i = 0; i < linesWithSegments.size(); i++) {
            if (linesWithSegments.get(i).getName().equals(lineName)) return linesWithSegments.get(i);
        }
        return null;
    }

    @Override
    public void createSegment(LineName lineName, int index) {

    }

    @Override
    public void clearBuffer() {

    }

    @Override
    public StopInterface getStopByName(StopName name) {
        return null;
    }
}
