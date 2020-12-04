package Classes;

public class Instrumenti {
    public String saxeli;
    public String mwarmoebeli;
    public int fasi;

    public void setSaxeli(String saxeli) {
        this.saxeli = saxeli;
    }

    public String getSaxeli() {
        return saxeli;
    }

    public void setMwarmoebeli(String mwarmoebeli) {
        this.mwarmoebeli = mwarmoebeli;
    }

    public String getMwarmoebeli() {
        return mwarmoebeli;
    }

    public void setFasi(int fasi) {
        this.fasi = fasi;
    }

    public int getFasi() {
        return fasi;
    }

    public void Instrumenti(String saxeli, String mwarmoebeli, int fasi) {
        this.saxeli = saxeli;
        this.mwarmoebeli = mwarmoebeli;
        this.fasi = fasi;
    }


}
