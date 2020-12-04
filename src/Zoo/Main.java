package Zoo;

public class Main {
    public static void main(String[] args) {

        Animal animal1 = new Animal("pirveli", 5);
        Animal animal2 = new Animal("meore", 4);
        Animal animal3 = new Animal("mesame", 20);
        Animal animal4 = new Animal("meotxe", 15);

        Animal [] animals1 = new Animal[2];
        Animal [] animals2 = new Animal[2];

        animals1[0] = animal1;
        animals1[1] = animal2;
        animals2[0] = animal3;
        animals2[1] = animal4;

        Vivarium vivarium1 = new Vivarium(animals1, 10, 2010);
        Vivarium vivarium2 = new Vivarium(animals2, 12, 2015);

        Vivarium [] vivariums = new Vivarium[2];
        vivariums[0] = vivarium1;
        vivariums[1] = vivarium2;

        Zoo zoo = new Zoo(vivariums);

        System.out.println(zoo.toString());
        System.out.println(zoo.getCosts());
    }
}
