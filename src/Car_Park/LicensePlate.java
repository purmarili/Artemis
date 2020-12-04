package Car_Park;

// No setters, since a license plate should be immutable
public class LicensePlate {
    private String regionalCode;
    private String letters;
    private int digits;

    public LicensePlate(String regionalCode, String letters, int digits) {
        this.regionalCode = regionalCode;
        this.letters = letters;
        this.digits = digits;
    }

    public boolean isEqual(LicensePlate other) {
        return digits == other.digits &&
                letters.equals(other.letters) &&
                regionalCode.equals(other.regionalCode);
    }

    public String toString() {
        return regionalCode + ":" + letters + " " + digits;
    }

    public String getRegionalCode() {
        return regionalCode;
    }

    public int getDigits() {
        return digits;
    }

    public String getLetters() {
        return letters;
    }


}