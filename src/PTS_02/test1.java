package PTS_02;

import PTS_02.dataStorage.GetDataFromFile;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;

import java.io.FileNotFoundException;

public class test1 {
    public static void main(String[] args) throws FileNotFoundException {
        GetDataFromFile data = new GetDataFromFile("stops.txt", "lines.txt");
        ConnectionSearch cs = new ConnectionSearch(new Stops(data), new Lines(data));
        System.out.println("A");
        cs.search(new StopName("Hl.st."), new StopName("Zochova"), new Time(1));
    }
}
