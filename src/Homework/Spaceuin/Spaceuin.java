package Homework.Spaceuin;

import java.util.ArrayList;
import java.util.List;

public class Spaceuin extends Thread {

    private ArrayList<Beacon> been = new ArrayList<>();
    private ArrayList<Spaceuin> wormHoles = new ArrayList<>();

    private Beacon from;
    private Beacon to;
    private FlightRecorder flightRecorder;
    private Spaceuin parent;

    public Spaceuin(Beacon start, Beacon destination, FlightRecorder flightRecorder) {
        this.from = start;
        this.to = destination;
        this.flightRecorder = flightRecorder;
    }

    public Spaceuin(Beacon start, Beacon destination, FlightRecorder flightRecorder, Spaceuin parent) {
        this.from = start;
        this.to = destination;
        this.flightRecorder = flightRecorder;
        this.parent = parent;
    }

    @Override
    public void run() {
        explore(from);
    }

    private void explore(Beacon next) {
        List<BeaconConnection> currConnections;
        BeaconConnection bc = null;
        Beacon helper = null;
        Beacon after = null;
        synchronized (next) {
            if (isInterrupted()) return;
            flightRecorder.recordArrival(next);
            if (next == to) {
                markArrival(this);
                flightRecorder.tellStory();
                return;
            }
            currConnections = next.connections();
            if (!been.contains(next)) been.add(next);
            for (int i = 0; i < currConnections.size(); i++) {
                bc = currConnections.get(i);
                helper = bc.beacon();
                // creating new space
                if (!been.contains(helper)) {
                    if (bc.type() == ConnectionType.WORMHOLE) {
                        synchronized (this) {
                            if (isInterrupted()) return;
                            Spaceuin newSpace = new Spaceuin(helper, to, flightRecorder.createCopy(), this);
                            wormHoles.add(newSpace);
                            newSpace.start();
                        }
                    }
                }
            }

            after = getBeacon(next, currConnections, after);
        }
        while (after != null) {
            explore(after);
            after = null;
            synchronized (next) {
                if (isInterrupted()) return;
                flightRecorder.recordArrival(next);
                after = getBeacon(next, currConnections, after);
            }
        }


    }

    private Beacon getBeacon(Beacon next, List<BeaconConnection> currConnections, Beacon after) {
        BeaconConnection bc;
        Beacon helper;
        for (int i = 0; i < currConnections.size(); i++) {
            bc = currConnections.get(i);
            helper = bc.beacon();
            if (!been.contains(helper)) {
                if (bc.type() == ConnectionType.NORMAL) {
                    after = helper;
                    break;
                }
            }
        }
        flightRecorder.recordDeparture(next);
        return after;
    }

    private synchronized void markArrival(Spaceuin toCkeck) {
        if (parent != null)
            if (parent != toCkeck)
                parent.markArrival(this);
        for (int i = 0; i < wormHoles.size(); i++) {
            if (toCkeck != wormHoles.get(i))
                wormHoles.get(i).markArrival(this);
        }
        interrupt();
    }
}
