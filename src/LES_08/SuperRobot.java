package LES_08;

public class SuperRobot extends Robot {
    private int p;

    public SuperRobot(int age, String name, String color, int p){
        this.p = p;
    }


    public SuperRobot(){
        super();
        this.p = 1;
    }

    @Override
    public void print(){
        System.out.println("I am super robot");
    }

    public void h(){
        System.out.println("Hey");
    }
}
