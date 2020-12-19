package Zoo;

public class Vivarium {
    private Animal[] animals;
    private int area;
    private int constructionYear;

    public Vivarium(Animal[] animals, int area, int constructionYear){
        this.animals = animals;
        this.area = area;
        this.constructionYear = constructionYear;
    }

    public String toString(){
        // A pretty inefficient implementation.
        // One should rather use StringBuilder or StringBuffer.
        String result = "[area: " + area + ", constructionYear: " + constructionYear + ", animals: ";
        for(int i = 0; i< animals.length; i++){
            result += animals[i].toString();
            if(i!= animals.length - 1){
                result += ", ";
            } else {
                result += "]";
            }
        }
        return result;
    }

    public int getCosts(){
        int totalFoodCosts = 0;
      	for(int i = 0; i< animals.length; i++){
        	totalFoodCosts += animals[i].getFoodCosts();
        }
        return totalFoodCosts + 900 + area * 100 + area * (2019 - constructionYear) * 5;
    }

}
