package Test;

public class Datka {
    private int a;
    private String str;

    public Datka(String str){
        this.str = str;
        a = 5;
    }

    public Datka(String str, int a){
        String s = "";
        for (int i=0; i<str.length() / 2; i++)
            s += str.charAt(i);
        this.str = s;
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
