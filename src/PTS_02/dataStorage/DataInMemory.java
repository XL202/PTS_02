package PTS_02.dataStorage;

import PTS_02.*;
import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.TimeDiff;

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
        lines.add(createLineNameClass("bus93"));
        lines.add(createLineNameClass("bus32"));
        stops.add(new Stop(new StopName("Hl.st."), lines));
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
        lines.removeLast();
        stops.add(new Stop(new StopName("Slavicie"), lines));

        //
        lines.add(createLineNameClass("bus32"));
        //32
        stops.add(new Stop(new StopName("Kramare"), lines));
        stops.add(new Stop(new StopName("Botanicka"), lines));
        lines.removeLast();
        stops.add(new Stop(new StopName("DlheDiely"), lines));

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
            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(new Time(time.getTime()+0), 0);
            }

            nextStop = getStopByName(new StopName("Zochova"));
            segments.add(new LineSegment(new TimeDiff(5), nextStop, 3, createLineNameClass("Zochova"), currentCapacity));

            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(new Time(time.getTime()+5), 0);
            }
            nextStop = getStopByName(new StopName("ZOO"));
            segments.add(new LineSegment(new TimeDiff(8), nextStop, 3, createLineNameClass("ZOO"), currentCapacity));

            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(new Time(time.getTime()+13), 0);
            }
            nextStop = getStopByName(new StopName("Slavicie"));
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
            nextStop = getStopByName(new StopName("Kramare"));
            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(time, 0);
            }
            segments.add(new LineSegment(new TimeDiff(6), nextStop, 3, createLineNameClass("Kramare"), currentCapacity));

            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(new Time(time.getTime()+6), 0);
            }
            nextStop = getStopByName(new StopName("ZOO"));
            segments.add(new LineSegment(new TimeDiff(5), nextStop, 3, createLineNameClass("ZOO"), currentCapacity));

            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(new Time(time.getTime()+11), 0);
            }
            nextStop = getStopByName(new StopName("Botanicka"));
            segments.add(new LineSegment(new TimeDiff(2), nextStop, 3, createLineNameClass("Botanicka"), currentCapacity));

            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(new Time(time.getTime()+13), 0);
            }
            nextStop = getStopByName(new StopName("DlheDiely"));
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
            nextStop = getStopByName(new StopName("Zochova"));
            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(time, 0);
            }
            segments.add(new LineSegment(new TimeDiff(5), nextStop, 3, createLineNameClass("Zochova"), currentCapacity));

            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(new Time(time.getTime()+5), 0);
            }
            nextStop = getStopByName(new StopName("Aupark"));
            segments.add(new LineSegment(new TimeDiff(2), nextStop, 3, createLineNameClass("Aupark"), currentCapacity));

            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(new Time(time.getTime()+7), 0);
            }
            nextStop = getStopByName(new StopName("Petrzalka"));
            segments.add(new LineSegment(new TimeDiff(3), nextStop, 3, createLineNameClass("Petrzalka"), currentCapacity));

            currentCapacity = new HashMap<>();
            for (Time time : times) {
                currentCapacity.put(new Time(time.getTime()+10), 0);
            }
            nextStop = getStopByName(new StopName("Vysehradska"));
            segments.add(new LineSegment(new TimeDiff(9), nextStop, 3, createLineNameClass("Vysehradska"), currentCapacity));

        }
        linesWithSegments.add(new Line(createLineNameClass("bus93"), times, startStop, segments, stopsName));
        //line93 to segments end
        /*for (StopInterface stop : stops) {

            System.out.println(stop.getName().toString());
        }
        System.out.println(stops.toString());*/
    }
    public LineName createLineNameClass(String lineName) {
        return new LineName(lineName);
    }

    public StopInterface getStopByName(StopName name) {
        for (StopInterface stop : stops) {

            if (stop.getName().equals(name)) return stop;
        }
        return null;
    }


    @Override
    public LineInterface getLineByName(LineName lineName) {
        for (Line linesWithSegment : linesWithSegments) {
            if (linesWithSegment.getName().equals(lineName)) return linesWithSegment;
        }
        return null;
    }

    @Override
    public void createSegment(LineName lineName, int index) {

    }

    @Override
    public void clearBuffer() {

    }
}
