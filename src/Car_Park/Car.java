package Car_Park;

// neither chassisNumber nor count should be modifiable from the outside, count should not be visible
public class Car {
    private String brand;
    private LicensePlate licensePlate;
    private int serialNumber;

    public static int count = 0;

    public Car(String brand, LicensePlate licensePlate) {
        this.brand = brand;
        this.licensePlate = licensePlate;

        count++;
        this.serialNumber = count;
    }

    public String toString() {
        return "Car " + serialNumber + " : (Brand: " + brand + ", License Plate: " + licensePlate + ")";
    }

    public String getBrand() {
        return brand;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

}