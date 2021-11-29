package PTS_02;

import java.io.FileNotFoundException;

public class test {

    public static void main(String[] args) throws FileNotFoundException {
        FileConnection fc = new FileConnection();
        fc.getStopsData("Stops.txt");
    }
}
