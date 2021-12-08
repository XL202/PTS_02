package PTS_02.datatypes;

import java.util.Collections;
import java.util.LinkedList;

public class ConnectionData {

    private StopName lastStop;
    private final LinkedList<Quadraplet<LineName, StopName, Time, TimeDiff>> travelSegments = new LinkedList<>();

    public void setLastStop(StopName lastStop) {
        this.lastStop = lastStop;
    }

    public void addTravelSegment(LineName lineName, StopName startStop, Time startTime, TimeDiff travelTime) {
        travelSegments.add(new Quadraplet<>(lineName, startStop, startTime, travelTime));
    }

    public StopName getLastStop() {
        return lastStop;
    }

    public LinkedList<Quadraplet<LineName, StopName, Time, TimeDiff>> getTravelSegments() {
        LinkedList<Quadraplet<LineName, StopName, Time, TimeDiff>> result = new LinkedList<>(travelSegments);
        Collections.reverse(result);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=travelSegments.size()-1; i>=0; i--) {
            Quadraplet<LineName, StopName, Time, TimeDiff> data = travelSegments.get(i);
            sb.append("Stop: ").append(data.getSecond().toString());
            sb.append(", by line: ").append(data.getFirst().toString());
            sb.append(", arrival time of bus to stop: ").append(data.getThird().toString());
            sb.append(", segment travel time: ").append(data.getFourth().getTimeDiff());
            sb.append(";\n");
        }
        sb.append("Last stop: ").append(lastStop.toString());
        sb.append("\n");
        return sb.toString();
    }

}
