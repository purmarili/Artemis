package LES_04;

public class Car {

    private int age;
    private int saxelmwifoNomeri;
    private String modeli;
    private String marka;

    public Car(){
        this.age = 5;
        this.saxelmwifoNomeri = 5;
        this.modeli = "a";
        this.marka = "b";
    }

    public Car(int age, int saxelmwifoNomeri, String modeli, String marka){
        this.age = age;
        this.saxelmwifoNomeri = saxelmwifoNomeri;
        this.modeli = modeli;
        this.marka = marka;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSaxelmwifoNomeri() {
        return saxelmwifoNomeri;
    }

    public void setSaxelmwifoNomeri(int saxelmwifoNomeri) {
        this.saxelmwifoNomeri = saxelmwifoNomeri;
    }

    public String getModeli() {
        return modeli;
    }

    public void setModeli(String modeli) {
        this.modeli = modeli;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }
}
