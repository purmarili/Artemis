package LES_12;

public class Robot<T> {
    public static int number = 0;
    private T friend;
    private int age;
    private String name;
    private String color;

    public static int getNumber(){
        return number;
    }

    public Robot(int age, String name, String color, T p) {
        this.friend = p;
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public Robot(T p) {
        this.friend = p;
        this.age = 10000;
        this.name = "DEFAULT";
        this.color = "BLACK";
    }

    public T getFriend(){
        return friend;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public void print() {
        System.out.println("I am robot");
    }
}
