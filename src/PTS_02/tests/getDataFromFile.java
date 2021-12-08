package PTS_02.tests;

import PTS_02.*;
import PTS_02.dataStorage.GetDataFromFile;
import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.exceptions.IncorrectUserInputException;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class getDataFromFile {


    @Test
    public void getDataFromFileAndTestStops() throws FileNotFoundException, IncorrectUserInputException {
        GetDataFromFile data = new GetDataFromFile("stops.txt", "lines.txt");
        StopsInterface stops = new Stops(data);
        assertFalse(stops.isLoaded(new StopName("Zochova")));
        stops.loadStop(new StopName("Zochova"));
        assertTrue(stops.isLoaded(new StopName("Zochova")));
        stops.loadStop(new StopName("Zochova"));
        stops.loadStop(new StopName("bus93"));
        assertEquals(stops.getLines(new StopName("Hl.st.")).toString(), "[bus93, bus32]");
        assertEquals(stops.getLines(new StopName("ZOO")).toString(), "[bus31, bus32]");
    }
    @Test
    public void getDataFromFileAndTestLines() throws FileNotFoundException, IncorrectUserInputException {
        GetDataFromFile data = new GetDataFromFile("stops.txt", "lines.txt");
        LinesInterface lines = new Lines(data);
        assertFalse(lines.isLoaded(new LineName("Zochova")));
        lines.loadLine(new LineName("bus93"));
        assertTrue(lines.isLoaded(new LineName("bus93")));
        lines.loadLine(new LineName("Zochova"));
        lines.loadLine(new LineName("bus93"));
        LineInterface testLine = lines.getLineByLineName(new LineName("bus93"));
        assertEquals(testLine.getStopsOnThisLine().toString(),"[Hl.st., Zochova, Aupark, Petrzalka, Vysehradska]");
        assertEquals(testLine.getStartTimes().toString(),"[0, 5, 10, 15, 20, 25]");
        System.out.println(testLine.getLineSegments().get(0));
        System.out.println(testLine.getLineSegments().get(1));
        System.out.println(testLine.getLineSegments().get(2));
        System.out.println(testLine.getLineSegments().get(3));

        lines.loadLine(new LineName("bus32"));
        LineInterface testLine1 = lines.getLineByLineName(new LineName("bus32"));
        System.out.println(testLine1.getStopsOnThisLine().toString());
        System.out.println(testLine1.getStartTimes().toString());
        System.out.println(testLine1.getLineSegments().get(0));
        System.out.println(testLine1.getLineSegments().get(1));
        System.out.println(testLine1.getLineSegments().get(2));
        System.out.println(testLine1.getLineSegments().get(3));



        /*stops.loadStop(new StopName("bus93"));
        assertEquals(stops.getLines(new StopName("Hl.st.")).toString(), "[bus93, bus32]");
        assertEquals(stops.getLines(new StopName("ZOO")).toString(), "[bus31, bus32]");*/
    }
}
