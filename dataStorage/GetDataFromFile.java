package PTS_02.dataStorage;

import PTS_02.*;
import PTS_02.datatypes.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class GetDataFromFile implements StopsFactoryInterface, LinesFactoryInterface {
    LinkedList<LineName> lines;
    LinkedList<StopInterface> stops;

    public GetDataFromFile(String stopSetName, String linesSetName) throws FileNotFoundException {
        lines = getLineNames(linesSetName);
        stops = getStops(stopSetName);
        //System.out.println(stops.toString());
    }

    public LinkedList<LineName> getLineNames(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        LinkedList<LineName> lines = new LinkedList<>();
        while(sc.hasNext()) {
            lines.add(new LineName(sc.next()));
        }
        sc.close();
        return lines;
    }
    public LinkedList<StopInterface> getStops(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        LinkedList<StopInterface> stops = new LinkedList<>();
        LinkedList<LineName> lines;
        while(sc.hasNextLine()) {
            Scanner row = new Scanner(sc.nextLine());
            StopName stopName = new StopName(row.next());
            lines = new LinkedList<>();
            while(row.hasNext()) lines.add(new LineName(row.next()));
            stops.add(new Stop(stopName, lines));
            row.close();
        }
        sc.close();
        return stops;
    }
    @Override
    public StopInterface getStopByName(StopName name) {
        for (int i = 0; i < stops.size(); i++) {
            if (stops.get(i).getName().equals(name)) return stops.get(i);
        }
        return null;
    }
    public LinkedList<LineInterface> getLinesData() throws FileNotFoundException {
        LinkedList<LineInterface> tmp = new LinkedList<>();
        for(int i=0; i< lines.size(); i++) {
            tmp.add(getLineData(lines.get(i).toString() + ".txt", lines.get(i).toString()));
        }
        return tmp;
    }
    public LineInterface getLineData(String lineFileName, String lineName) throws FileNotFoundException {
        long lastDiffFromStart = 0;
        long currentDiffFromStart;
        TimeDiff diff;
        HashMap<Time,Integer> currentCapacity;
        Line line;
        File file = new File(lineFileName);
        Scanner sc = new Scanner(file);
        LinkedList<StopName> stopsOnLine;
        //first is startStop
        StopName startStop;
        StopInterface nextStop;
        Scanner header = new Scanner(sc.nextLine());
        LinkedList<LineSegmentInterface> segments = new LinkedList<>();
        startStop = new StopName(header.next());
        LinkedList<Time> times = new LinkedList<>();
        LinkedList<StopName> stops = new LinkedList<>();
        stopsOnLine = new LinkedList<>();
        stopsOnLine.add(startStop);
        while(header.hasNextLong()) {
            times.add(new Time(header.nextLong()));
        }
        header.close();

        while(sc.hasNextLine()) {
            Scanner row = new Scanner(sc.nextLine());

            stopsOnLine.add(new StopName(row.next()));
            System.out.println(stopsOnLine.getLast());
            nextStop = getStopByName(stopsOnLine.getLast());
            currentDiffFromStart = row.nextLong();
            diff = new TimeDiff(currentDiffFromStart);
            int capacity = row.nextInt();
            currentCapacity = new HashMap<>();
            for (int i = 0; i < times.size(); i++) {
                currentCapacity.put(new Time(times.get(i).getTime()+currentDiffFromStart), row.nextInt());
            }
            //lastDiffFromStart = currentDiffFromStart;
            //if (nextStop != null)
            segments.add(new LineSegment(diff, nextStop, capacity, new LineName(lineName), currentCapacity));
        }
//LineName lineName, LinkedList<Time> startTimes, StopName startStop, LinkedList<LineSegmentInterface> lineSegments
        line = new Line(new LineName(lineName), times, startStop, segments, stopsOnLine);
        sc.close();

        return line;
    }

    @Override
    public LineInterface getLineByName(LineName lineName) throws FileNotFoundException {
        try {
            return getLineData(lineName.toString() + ".txt" , lineName.toString());
        }
        catch (FileNotFoundException e){
            System.out.println("FileNotFoundException: " + e.getMessage());
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
