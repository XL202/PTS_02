package PTS_02;

import java.util.LinkedList;

public class Stop {
    private StopName name;
    private LinkedList<Reachible> reachible;
    public Stop(StopName name, LinkedList<Reachible> reachible) {
        this.name = name;
        this.reachible = new LinkedList<>(reachible);
    }

    public StopName getName() {
        return name;
    }

    public LinkedList<Reachible> getReachible(StopName from) {
        LinkedList<Reachible> tmp = new LinkedList<>();
        return tmp;
    }
}
