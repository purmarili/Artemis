package Homework.PinguTracking;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Penguin {
    private List<Geo> locations;
    private String trackID;

    public Penguin(List<Geo> locations, String trackID) {
        this.locations = locations;
        this.trackID = trackID;
    }

    @Override
    public String toString() {
        return "Penguin{" +
                "locations=" + locations +
                ", trackID='" + trackID + '\'' +
                '}';
    }

    public List<Geo> getLocations() {
        return locations;
    }

    public String getTrackID() {
        return trackID;
    }

    public String toStringUsingStreams() {

        List<Geo> loc = locations.stream().sorted(Comparator.comparing(Geo::getLatitude)).sorted(Comparator.
                comparing(Geo::getLongitude)).collect(Collectors.toList());

        String finalresult = "Penguin{locations=" + loc + ", trackID='" + trackID + "'}";

        return finalresult;
    }
}


//Comparator<Geo> comparator = (pr1, pr2) -> {
//  if (Double.compare(pr1.latitude, pr2.latitude) == 0) {
//    	return Double.compare(pr1.longitude, pr2.longitude);
//}
//	return Double.compare(pr1.latitude, pr2.latitude);
//};


//      List<Geo>loc = locations.stream().sorted(Comparator.comparing(Geo::getLongitude).reversed()).sorted(Comparator.
//comparing(Geo::getLatitude).reversed()).collect(Collectors.toList());


// List<Stream> l =  locations.stream().sorted(comparator.comparing(x -> x.getlatitude).sorted(compararor.compating(y -> y.longitude)));
