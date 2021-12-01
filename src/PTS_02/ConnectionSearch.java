package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.IncorrectUserInputException;

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
        try {

            stops.setStartingStop(from, time);

            LinkedList<StopName> earliestStops = new LinkedList<>(List.of(from));
            while (!earliestStops.contains(to)) {
                while (!earliestStops.isEmpty()) {
                    StopName tmpStop = earliestStops.remove(earliestStops.size() - 1);
                    LinkedList<LineName> stopLines = stops.getLines(tmpStop);
                    lines.updateReachable(stopLines, tmpStop, time);
                }
                Pair<LinkedList<StopName>, Time> data = stops.earliestReachableStopAfter(time);
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

                //Triplet<StopName, Time, TimeDiff> resultData = lines.updateCapacityAndGetPreviousStop(data.getSecond(), tmpStop, data.getFirst());
                //result.addTravelSegment(data.getSecond(), resultData.getFirst(), resultData.getSecond(), resultData.getThird());
                //tmpStop = resultData.getFirst();
            }

            lines.saveUpdatedLineSegments();

            return result;

        } catch (IncorrectUserInputException e) {
            System.out.println("Incorrect user input: " + e.getMessage());
            return null;

        } finally {
            lines.clean();
            stops.clean();
        }
    }
}
