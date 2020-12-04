package Classes;

public class Saofise extends Aveji {
    public String tipi = "saofise";
    public int raod;

    public void setRaod(int raod) {
        this.raod = raod;
    }

    public int getRaod() {
        return raod;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public String getTipi() {
        return tipi;
    }


    public void Saofise(String masala, String compania, String tipi, int raod) {
        super.Aveji(masala, compania, tipi);
        this.raod = raod;
    }

    public void printing() {
        System.out.println("masala-" + getMasala());
        System.out.println("compania-" + getCompania());
        System.out.println("tipi-" + "saofise");
        System.out.println("raodenoba" + getRaod());
    }

}
