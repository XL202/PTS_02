package PTS_02;

import PTS_02.datatypes.*;

public class testConnectionData {
    public static void main(String[] args) {
        ConnectionData connectionData = new ConnectionData();
        connectionData.setLastStop(new StopName("Slavicie"));
        System.out.println(connectionData.getLastStop());

        connectionData.addTravelSegment(new LineName("bus93"), new StopName("Zochova"), new Time(0), new TimeDiff(5));
        connectionData.addTravelSegment(new LineName("bus31"), new StopName("ZOO"), new Time(5), new TimeDiff(8));
        connectionData.addTravelSegment(new LineName("bus31"), new StopName("Slavicie"), new Time(13), new TimeDiff(2));
        System.out.println(connectionData);

    }


}
