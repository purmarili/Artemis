package Classes;

public class Gitara extends Simebiani {
    String tipi;

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public String getTipi() {
        return tipi;
    }

    public void Gitara(String saxeli, String mwarmoebeli, int fasi, int raod, String dakvtipi, String tipi) {
        super.Simebiani(saxeli, mwarmoebeli, fasi, raod, dakvtipi);
        this.tipi = tipi;
    }

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

    public void setDakvipi(String dakvtipi) {
        this.dakvtipi = dakvtipi;
    }

    public int getRaod() {
        return raod;
    }

    public String getDakvipi() {
        return dakvtipi;
    }

    public void printinfo() {
        System.out.println("saxeli" + getSaxeli());
        System.out.println("mwarmoebeli" + getMwarmoebeli());
        System.out.println("fasi" + getFasi());
        System.out.println("dakbris tipi" + getDakvipi());
        System.out.println("raodenoba" + getRaod());
        System.out.println("tipi" + getTipi());
    }
}
