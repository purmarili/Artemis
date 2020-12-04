package Classes;


public class Simebiani extends Instrumenti {
    public int raod;
    public String dakvtipi;

    public void setRaod(int raod) {
        this.raod = raod;
    }

    public void setTipi(String dakvtipi) {
        this.dakvtipi = dakvtipi;
    }

    public int getRaod() {
        return raod;
    }

    public String getTipi() {
        return dakvtipi;
    }

    public void Simebiani(String saxeli, String mwarmoebeli, int fasi, int raod, String dakvtipi) {
        super.Instrumenti(saxeli, mwarmoebeli, fasi);
        this.raod = raod;
        this.dakvtipi = dakvtipi;
    }

}
