package PTS_02;

import PTS_02.datatypes.LineName;
import PTS_02.datatypes.StopName;
import PTS_02.datatypes.Time;
import PTS_02.datatypes.Triplet;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class FileConnection implements FileConnectionInterface {


    public LinkedList<Triplet<StopName, LinkedList<LineName>, LinkedList<Triplet<StopName, Time, LineName>>>> getStopsData(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        System.out.println(sc.nextLine());
        while(sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();
        return null;
    }
}
