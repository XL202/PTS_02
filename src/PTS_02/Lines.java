package PTS_02;

import PTS_02.datatypes.*;
import PTS_02.exceptions.FullCapacityException;
import PTS_02.exceptions.IncorrectUserInputException;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Lines implements LinesInterface{
    private final LinesFactoryInterface factory;
    private HashMap<LineName, LineInterface> lines = new HashMap<>();

    public Lines(LinesFactoryInterface factory) {
        this.factory = factory;
    }

    private void loadLine(LineName line) throws IncorrectUserInputException, FileNotFoundException {
        if (lines.containsKey(line)) throw new IllegalStateException("Line has already been loaded.");

        LineInterface newLine = factory.getLineByName(line);
        System.out.println("loaded line: " + newLine.toString());
        System.out.println("line's start times: " + newLine.getStartTimes());
        System.out.println("line's segments" + newLine.getLineSegments());
        if (newLine == null) throw new IncorrectUserInputException("No such line in database.");
        lines.put(line, newLine);
        System.out.println(lines);

    }

    @Override
    public void updateReachable(LinkedList<LineName> lines, StopName stop, Time time) throws IncorrectUserInputException, FileNotFoundException {
        System.out.printf("lines.updateReachable(lines,AtStop,Time): [%s, %s, %s]\n",lines.toString(), stop, time.getTime());
        for (LineName line : lines) {
            System.out.printf("loading line '%s'\n",line.toString());
            if (!this.lines.containsKey(line)) {

                loadLine(line);
            }
            System.out.printf("lines.get(line).updateReachable(time, stop): [%s, %s, %s]\n",line,time.getTime(),stop);

            this.lines.get(line).updateReachable(time, stop);
        }
    }

    @Override
    public Triplet<StopName, Time, TimeDiff> updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time busStartTime) throws FullCapacityException, IncorrectUserInputException, FileNotFoundException {

        if (!lines.keySet().contains(line)) throw new NoSuchElementException("Line has not been loaded yet.");
        System.out.println("OK");
        return lines.get(line).updateCapacityAndGetPreviousStop(stop, busStartTime);
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
