package LES_08;

public class Robot {
    private int age;
    private String name;
    private String color;

    public Robot(int age, String name, String color){
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public Robot(){
        this.age = 10000;
        this.name = "DEFAULT";
        this.color = "BLACK";
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


    public void print(){
        System.out.println("I am robot");
    }
}
