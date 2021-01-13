package Homework.PinguTracking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataScience {
    public static Stream<Penguin> getDataByTrackId(Stream<PenguinData> stream) {
        HashMap<String, ArrayList<Geo>> trackMap = new HashMap<>();
        stream.forEach(trackData -> {
            if (!trackMap.containsKey(trackData.getTrackID())) {
                trackMap.put(trackData.getTrackID(), new ArrayList<>());
            } else {
                Geo currGeo = new Geo(trackData.getLatitude(), trackData.getLongitude());
                trackMap.get(trackData.getTrackID()).add(currGeo);
            }
        });
        HashSet<Penguin> penguins = new HashSet<>();
        Iterator<String> it = trackMap.keySet().iterator();
        while (it.hasNext()) {
            String currId = it.next();
            Penguin pengu = new Penguin(trackMap.get(currId), currId);
            penguins.add(pengu);
        }
        return penguins.stream();
    }

    public static void outputPenguinStream() {
        ArrayList<Penguin> dataByID = new ArrayList<>();
        long size = 0;
        dataByID = getDataByTrackId(CSVReading.processInputFile()).sorted(Comparator.comparing(Penguin::getTrackID))
                .collect(Collectors.toCollection(ArrayList::new));
        size = dataByID.size();
        System.out.println(size);
        dataByID.stream().forEach(data -> {
            System.out.println(data.toStringUsingStreams());
        });
    }

    public static void outputLocationRangePerTrackid(Stream<PenguinData> stream) {
        Stream<Penguin> streamPengu = getDataByTrackId(stream);
        streamPengu.sorted(Comparator.comparing(Penguin::getTrackID)).forEach(x -> {
            System.out.println(x.getTrackID());
            List<Geo> penguList = x.getLocations();
            ArrayList<Double> arrLatitude = new ArrayList<>();
            ArrayList<Double> arrLongtitude = new ArrayList<>();

            penguList.stream().forEach(tmp -> {
                arrLatitude.add(tmp.getLatitude());
                arrLongtitude.add(tmp.getLongitude());
            });

            double minLatitude = arrLatitude.stream().mapToDouble(Double::doubleValue).min().getAsDouble();
            double minLongitude = arrLongtitude.stream().mapToDouble(Double::doubleValue).min().getAsDouble();
            double maxLatitude = arrLatitude.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
            double maxLongitude = arrLongtitude.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
            double avgLatitude = arrLatitude.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            double avgLongitude = arrLongtitude.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.println("Min Longitude: " + minLongitude + " Max Longitude: " + maxLongitude + " Avg Longitude: "
                    + avgLongitude + " Min Latitude: " + minLatitude + " Max Latitude: " + maxLatitude
                    + " Avg Latitude: " + avgLatitude);
        });
    }

    public static void main(String[] args) {
        // TODO Test your implementation yourself
    }
}