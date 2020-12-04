package Classes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Saofise[] saofise = new Saofise[4];
        for (int i = 0; i < 5; i++) {
            Saofise s = new Saofise();
            s.Saofise(sc.nextLine(), sc.nextLine(), "saofise", sc.nextInt());
            saofise[i] = s;
        }
        Saofise answ = new Saofise();
        answ.Saofise("asca", "ascWDQ", "Saofise", 0);
        for (Saofise s : saofise) {
            if (s.getRaod() > answ.getRaod()) {
                answ.setRaod(s.getRaod());
                answ.setTipi(s.getTipi());
                answ.setCompania(s.getCompania());
                answ.setMasala(s.getMasala());
            }
        }
        answ.printing();
        Gitara[] gitara = new Gitara[3];
        gitara[0].setSaxeli(sc.nextLine());
        gitara[0].setMwarmoebeli(sc.nextLine());
        gitara[0].setFasi(sc.nextInt());
        gitara[0].setRaod(sc.nextInt());
        gitara[0].setDakvipi(sc.nextLine());
        gitara[0].setTipi(sc.nextLine());
        gitara[1].setSaxeli(sc.nextLine());
        gitara[1].setMwarmoebeli(sc.nextLine());
        gitara[1].setFasi(sc.nextInt());
        gitara[1].setRaod(sc.nextInt());
        gitara[1].setDakvipi(sc.nextLine());
        gitara[1].setTipi(sc.nextLine());
        gitara[2].setSaxeli(sc.nextLine());
        gitara[2].setMwarmoebeli(sc.nextLine());
        gitara[2].setFasi(sc.nextInt());
        gitara[2].setRaod(sc.nextInt());
        gitara[2].setDakvipi(sc.nextLine());
        gitara[2].setTipi(sc.nextLine());
        gitara[0].printinfo();
        gitara[1].printinfo();
        gitara[2].printinfo();

    }
}
