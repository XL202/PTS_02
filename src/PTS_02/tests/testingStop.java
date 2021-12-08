package PTS_02.tests;
import PTS_02.StopInterface;
import PTS_02.StopsInterface;
import PTS_02.Stop;
import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class testingStop {
    @Test
    public void testStop() {
        LinkedList<LineName> lines = new LinkedList<>();
        lines.add(new LineName("lineA"));
        lines.add(new LineName("lineB"));
        lines.add(new LineName("lineC"));
        StopInterface stop = new Stop(new StopName("stopA"), lines);

        assertEquals(stop.getLines(), lines);
        assertEquals(stop.getReachableAt().getFirst(), null);
        assertEquals(stop.getReachableAt().getSecond(), null);
        stop.updateReachableAt(new Time(3), new LineName("lineA"));
        assertEquals(stop.getReachableAt().getFirst(), new Time(3));
        assertEquals(stop.getReachableAt().getSecond(), new LineName("lineA"));
        stop.updateReachableAt(new Time(4), new LineName("lineA"));
        assertEquals(stop.getReachableAt().getFirst(), new Time(3));
        assertEquals(stop.getReachableAt().getSecond(), new LineName("lineA"));
        stop.updateReachableAt(new Time(4), new LineName("lineB"));
        assertEquals(stop.getReachableAt().getFirst(), new Time(3));
        assertEquals(stop.getReachableAt().getSecond(), new LineName("lineA"));
        stop.updateReachableAt(new Time(2), new LineName("lineB"));
        assertEquals(stop.getReachableAt().getFirst(), new Time(2));
        assertEquals(stop.getReachableAt().getSecond(), new LineName("lineB"));



    }
}
