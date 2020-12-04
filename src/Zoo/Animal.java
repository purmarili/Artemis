package Zoo;

public class Animal {
    private int foodCosts;
    private String name;

    public Animal(String name, int foodCosts){
        this.name = name;
        this.foodCosts = foodCosts;
    }

    public int getFoodCosts() {
        return foodCosts;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "(name: " + name + ", foodCosts: " + foodCosts + ")";
    }

}
