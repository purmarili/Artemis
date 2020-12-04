package Car_Park;

public class CarPark {
    private Car[] spaces; // null   --> spaces.length --> null.length --> Error

    public CarPark(int n) {
        spaces = new Car[n];
    }

    public int park(Car car) {
        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i] == null) {
                spaces[i] = car;
                return i;
            }
        }
        return -1;
    }

    public int search(LicensePlate lp) {
        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i] != null && spaces[i].getLicensePlate().isEqual(lp)) {
                return i;
            }
        }
        return -1;
    }

    public Car driveOff(LicensePlate lp) {
        int position = search(lp);

        if (position != -1) {
            Car car = spaces[position];
            spaces[position] = null;
            return car;
        } else {
            return null;
        }
    }


}