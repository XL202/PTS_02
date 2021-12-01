package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.FullCapacityException;
import PTS_02.exceptions.IncorrectUserInputException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Lines implements LinesInterface{
    private final LinesFactoryInterface factory;
    private HashMap<LineName, LineInterface> lines = new HashMap<>();

    public Lines(LinesFactoryInterface factory) {
        this.factory = factory;
    }

    private void loadLine(LineName line) throws IncorrectUserInputException {
        if (lines.containsKey(line)) throw new IllegalStateException("Line has already been loaded.");
        LineInterface newLine = factory.getLineByName(line);
        if (newLine == null) throw new IncorrectUserInputException("No such line in database.");
        lines.put(line, newLine);
    }

    @Override
    public void updateReachable(LinkedList<LineName> lines, StopName stop, Time time) throws IncorrectUserInputException {
        for (LineName line : lines) {
            if (!this.lines.containsKey(line)) loadLine(line);
            this.lines.get(line).updateReachable(time, stop);
        }
    }

    @Override
    public Triplet<StopName, Time, TimeDiff> updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time busStartTime) throws FullCapacityException {
        if (!lines.containsKey(line)) throw new NoSuchElementException("Line has not been loaded yet.");
        //return lines.get(line).updateCapacityAndGetPreviousStop(stop, busStartTime);
        return new Triplet<>(null,null,null);
    }

    @Override
    public void saveUpdatedLineSegments() {
        LinkedList<LineSegmentInterface> modifiedLineSegments = new LinkedList<>();
        for (LineName line : lines.keySet()) {
            LinkedList<LineSegmentInterface> lineSegments = lines.get(line).getLineSegments();
            for (LineSegmentInterface lineSegment : lineSegments) {
                if (!lineSegment.getUpdatedBusses().isEmpty()) modifiedLineSegments.add(lineSegment);
            }
        }
        //factory.updateDatabase(modifiedLineSegments);
    }

    @Override
    public void clean() {
        lines = new HashMap<>();
    }

    @Override
    public void updateSegment(LineName lineName, int index) {

    }
}
