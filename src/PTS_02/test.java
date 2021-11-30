package PTS_02;

import PTS_02.dataStorage.FileConnection;

import java.io.FileNotFoundException;

public class test {

    public static void main(String[] args) throws FileNotFoundException {
        FileConnection fc = new FileConnection("stops.txt", "lines.txt");
        fc.getLineData("bus31.txt", "bus31");
    }
}
