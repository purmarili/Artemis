package LES_05;

public class SuperRobot extends Robot {
    private int p;

    public SuperRobot(int age, String name, String color, int p){
        super(age, name, color);
        this.p = p;
    }

    public SuperRobot(){

    }

    public void print(){
        System.out.println(this.getAge() + this.getName() + this.getColor());
    }
}
