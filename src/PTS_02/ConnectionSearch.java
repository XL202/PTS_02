package PTS_02;

import PTS_02.dataStorage.GetDataFromFile;
import PTS_02.datatypes.*;
import PTS_02.exceptions.FullCapacityException;
import PTS_02.exceptions.IncorrectUserInputException;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class ConnectionSearch {
    private final StopsInterface stops;
    private final LinesInterface lines;

    public ConnectionSearch(StopsInterface stops, LinesInterface lines) {
        this.stops = stops;
        this.lines = lines;
    }

    public ConnectionData search(StopName from, StopName to, Time time) {
        System.out.println("From: " + from +  "; To: " + to + "; Time: " + time.getTime());
        try {
            System.out.printf("stops.setStartingStop(from, time): [%s;%s]\n", from, time.getTime());
            stops.setStartingStop(from, time);

            LinkedList<StopName> earliestStops = new LinkedList<>(List.of(from));
            System.out.println(earliestStops);
            while (!earliestStops.contains(to)) {
                //System.out.println("T1");
                while (!earliestStops.isEmpty()) {
                    //System.out.println("T2");
                    StopName tmpStop = earliestStops.removeLast();
                    LinkedList<LineName> stopLines = stops.getLines(tmpStop);
                    System.out.printf("stops.getLines(tmpStop): [%s, %s]\n", tmpStop.toString(), stopLines);
                    if (!stops.isLoaded(tmpStop)) stops.loadStop(tmpStop);

                    lines.updateReachable(stopLines, tmpStop, time);
                    /*LinkedList<StopName> tmp = new LinkedList<>(newLine.getStopsOnThisLine());
                    for(int i=0; i<tmp.size(); i++) {
                        stops.gettmp.get(i).

                    };*/
                }
                //stops.loadStop(new StopName("Zochova"));
                /*stops.loadStop(new StopName("Aupark"));
                stops.loadStop(new StopName("Petrzalka"));
                stops.loadStop(new StopName("Vysehradska"));*/
                Pair<LinkedList<StopName>, Time> data = stops.earliestReachableStopAfter(time);
                //System.out.println(data);
                if (data == null) {
                    System.out.println("No connection has been found");
                    return null;
                }
                earliestStops.addAll(data.getFirst());
                time = data.getSecond();
            }

            ConnectionData result = new ConnectionData();
            StopName tmpStop = to;
            result.setLastStop(tmpStop);
            while (!tmpStop.equals(from)) {
                Pair<Time, LineName> data = stops.getReachableAt(tmpStop);

                if (data.getSecond() == null) throw new NullPointerException("A stop other than starting stop was not reached by line.");
                /*System.out.println("T");
                System.out.println(data);
                System.out.println(data.getFirst());
                System.out.println(data.getSecond());*/
                //addTravelSegment(LineName lineName, StopName startStop, Time startTime, TimeDiff travelTime)
                Triplet<StopName, Time, TimeDiff> resultData = lines.updateCapacityAndGetPreviousStop(data.getSecond(), tmpStop, data.getFirst());
                result.addTravelSegment(data.getSecond(), resultData.getFirst(), resultData.getSecond(), resultData.getThird());
                tmpStop = resultData.getFirst();
            }

            lines.saveUpdatedLineSegments();

            return result;

        } catch (IncorrectUserInputException | FullCapacityException | FileNotFoundException e) {
            System.out.println("Incorrect user input: " + e.getMessage());
            return null;

        } finally {
            lines.clean();
            stops.clean();
        }
    }
}
