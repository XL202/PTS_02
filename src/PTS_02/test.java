package PTS_02;

import PTS_02.dataStorage.GetDataFromFile;

import java.io.FileNotFoundException;

public class test {

    public static void main(String[] args) throws FileNotFoundException {
        GetDataFromFile fc = new GetDataFromFile("stops.txt", "lines.txt");
        fc.getLineData("bus31.txt", "bus31");
    }
}
