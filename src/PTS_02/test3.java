package PTS_02;

import PTS_02.dataStorage.DataInMemory;
import PTS_02.dataStorage.GetDataFromFile;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;

public class test3 {
    public static void main(String[] args) {
        DataInMemory data = new DataInMemory();
        ConnectionSearch cs = new ConnectionSearch(new Stops(data), new Lines(data));
        cs.search(new StopName("Hl.st."), new StopName("Slavicie"), new Time(0));
    }
}
