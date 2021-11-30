package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.exceptions.FullCapacityException;

import java.util.HashMap;
import java.util.LinkedList;

public class Lines implements LinesInterface{
    private HashMap<LineName,LineInterface> lines; // pridat lazy loading
    private LinesFactoryInterface linesFactory;

    public Lines(LinesFactoryInterface linesFactory) {
        lines = new HashMap<>();
        this.linesFactory = linesFactory;
    }

    @Override
    public void updateReachable(LinkedList<LineName> onLines, StopName stopName, Time time)
    {
        for (LineName lineName: onLines)
        {
            getLineByName(lineName).updateReachable(time, stopName);
        }
    }

    @Override
    public StopName updateCapacityAndGetPreviousStop(LineName lineName, StopName stopName, Time time) throws FullCapacityException {
        return getLineByName(lineName).updateCapacityAndGetPreviousStop(stopName,time);
    }

    @Override
    public void clean()
    {
        lines = new HashMap<>();
        linesFactory.clearBuffer();
    }

    @Override
    public void updateSegment(LineName lineName, int index)
    {
        linesFactory.createSegment(lineName, index);
    }


    private LineInterface getLineByName(LineName lineName)
    {
        LineInterface line;

        if(lines.containsKey(lineName))
        {
            line = lines.get(lineName);
        }
        else {
            line = load(lineName);
            this.updateSegment(new LineName(line.toString()), 0);
        }
        return line;
    }
    private LineInterface load(LineName lineName)
    {
        LineInterface line = linesFactory.getLineByName(lineName);
        lines.put(lineName, line);
        return line;
    }


}
