package PTS_02.tests;

import PTS_02.datatypes.*;

import PTS_02.exceptions.FullCapacityException;
import PTS_02.exceptions.IncorrectUserInputException;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class dataTypes {
    @Test
    public void testLineName() {
        LineName ln = new LineName("a");
        assertEquals(ln.toString(),"a");

        ln = new LineName("");
        assertEquals(ln.toString(),"");
        try {
            ln = new LineName(null);
            assertEquals(ln.toString(),null);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Incorrect user input: " + e.getMessage());
        }
        ln = new LineName("bus93");
        LineName ln1 = new LineName("bus93");
        LineName ln2 = new LineName("bus32");
        assertTrue(ln.equals(ln1));
        assertFalse(ln.equals(ln2));
        assertFalse(ln1.equals(ln2));
    }

    @Test
    public void testStopName() {
        StopName sn = new StopName("Zochova");
        assertEquals(sn.toString(),"Zochova");

        sn = new StopName("");
        assertEquals(sn.toString(),"");
        try {
            sn = new StopName(null);
            assertEquals(sn.toString(),null);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Incorrect user input: " + e.getMessage());
        }
        sn = new StopName("ZOO");
        StopName sn1 = new StopName("ZOO");
        StopName sn2 = new StopName("Hl.st.");
        assertTrue(sn.equals(sn1));
        assertFalse(sn.equals(sn2));
        assertFalse(sn1.equals(sn2));
    }

    @Test
    public void testTime() {
        Time time = new Time(1);
        assertEquals(time.getTime(), 1);
        try {
            time = new Time(-1);
            assertEquals(time.getTime(),-1);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Incorrect user input: " + e.getMessage());
        }
        time = new Time(0);
        Time time1 = new Time(0);
        Time time2 = new Time(1);
        assertTrue(time.equals(time1));
        assertFalse(time.equals(time2));
        assertFalse(time1.equals(time2));
    }

    @Test
    public void testTimeDiff() {
        TimeDiff timeDiff = new TimeDiff(1);
        assertEquals(timeDiff.getTimeDiff(), 1);
        timeDiff = new TimeDiff(8, 4);
        assertEquals(timeDiff.getTimeDiff(), 4);
        timeDiff = new TimeDiff(7, 3);
        assertEquals(timeDiff.getTimeDiff(), 4);
        try {
            timeDiff = new TimeDiff(-1);
            assertEquals(timeDiff.getTimeDiff(),-1);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Incorrect user input: " + e.getMessage());
        }
        try {
            timeDiff = new TimeDiff(-1, -2);
            assertEquals(timeDiff.getTimeDiff(),1);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Incorrect user input: " + e.getMessage());
        }
        try {
            timeDiff = new TimeDiff(2, 4);
            assertEquals(timeDiff.getTimeDiff(),-2);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Incorrect user input: " + e.getMessage());
        }
        timeDiff = new TimeDiff(0);
        TimeDiff timeDiff1 = new TimeDiff(0);
        TimeDiff timeDiff2 = new TimeDiff(1);
        assertTrue(timeDiff.equals(timeDiff1));
        assertFalse(timeDiff.equals(timeDiff2));
        assertFalse(timeDiff1.equals(timeDiff2));
    }

    @Test
    public void testPair() {
        Pair<StopName, LineName> pair = new Pair<>(new StopName("a"), new LineName("b"));
        assertEquals(pair.getFirst(), new StopName("a"));
        assertEquals(pair.getSecond(), new LineName("b"));
        assertTrue(pair.getSecond().equals(new LineName("b")));
        assertFalse(pair.getSecond().equals(new LineName("c")));
        Pair<StopName, LineName> pair1 = new Pair<>(new StopName("a"), new LineName("b"));
        assertTrue(pair.equals(pair1));
        Pair<StopName, LineName> pair2 = new Pair<>(new StopName("a"), new LineName("c"));
        assertFalse(pair.equals(pair2));
        Pair<StopName, StopName> pair3 = new Pair<>(new StopName("a"), new StopName("b"));
        assertFalse(pair.equals(pair3));

    }

    @Test
    public void testTriplet() {
        Triplet<StopName, LineName, Time> triplet = new Triplet<>(new StopName("a"), new LineName("b"), new Time(0));
        assertEquals(triplet.getFirst(), new StopName("a"));
        assertEquals(triplet.getSecond(), new LineName("b"));
        assertTrue(triplet.getSecond().equals(new LineName("b")));
        assertFalse(triplet.getSecond().equals(new LineName("c")));
        assertEquals(triplet.getThird(), new Time(0));
        Triplet<StopName, LineName, Time> triplet1 = new Triplet<>(new StopName("a"), new LineName("b"), new Time(0));
        assertTrue(triplet.equals(triplet1));
        Triplet<StopName, LineName, Time> triplet2 = new Triplet<>(new StopName("a"), new LineName("b"), new Time(1));
        assertFalse(triplet1.equals(triplet2));
        Triplet<StopName, LineName, TimeDiff> triplet3 = new Triplet<>(new StopName("a"), new LineName("b"), new TimeDiff(1));
        assertFalse(triplet.equals(triplet3));
    }

    @Test
    public void testQuadraplet() {
        Quadraplet<StopName, LineName, Time, TimeDiff> quadraplet = new Quadraplet<>(new StopName("a"), new LineName("b"), new Time(0), new TimeDiff(3));
        assertEquals(quadraplet.getFirst(), new StopName("a"));
        assertEquals(quadraplet.getSecond(), new LineName("b"));
        assertTrue(quadraplet.getSecond().equals(new LineName("b")));
        assertFalse(quadraplet.getSecond().equals(new LineName("c")));
        assertEquals(quadraplet.getThird(), new Time(0));
        assertEquals(quadraplet.getFourth(), new TimeDiff(3));
        Quadraplet<StopName, LineName, Time, TimeDiff> quadraplet1 = new Quadraplet(new StopName("a"), new LineName("b"), new Time(0), new TimeDiff(3));
        assertTrue(quadraplet.equals(quadraplet1));
        Quadraplet<StopName, LineName, Time, TimeDiff> quadraplet2 = new Quadraplet(new StopName("a"), new LineName("b"), new Time(1), new TimeDiff(3));
        assertFalse(quadraplet1.equals(quadraplet2));
        Quadraplet<StopName, LineName, Time, Time> quadraplet3 = new Quadraplet(new StopName("a"), new LineName("b"), new Time(1), new Time(3));
        assertFalse(quadraplet.equals(quadraplet3));
    }
}
