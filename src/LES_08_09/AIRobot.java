package LES_08_09;

public class AIRobot extends SuperRobot{

    public AIRobot(){
        super();
//        System.out.println("I am the best one");
    }

    @Override
    public void print(){
        System.out.println("I am AI Robot");
    }

    public void cry(){
        System.out.println("crying");
    }
}