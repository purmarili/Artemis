package Zoo;

public class Vivarium {
    private Animal[] inhabitants;
    private int area;
    private int constructionYear;

    public Vivarium(Animal[] inhabitants, int area, int constructionYear){
        this.inhabitants = inhabitants;
        this.area = area;
        this.constructionYear = constructionYear;
    }

    public String toString(){
        // A pretty inefficient implementation.
        // One should rather use StringBuilder or StringBuffer.
        String result = "[area: " + area + ", constructionYear: " + constructionYear + ", animals: ";
        for(int i=0; i<inhabitants.length; i++){
            result += inhabitants[i].toString();
            if(i!=inhabitants.length - 1){
                result += ", ";
            } else {
                result += "]";
            }
        }
        return result;
    }

    public int getCosts(){
        int totalFoodCosts = 0;
      	for(int i=0; i<inhabitants.length; i++){
        	totalFoodCosts += inhabitants[i].getFoodCosts();
        }
        return totalFoodCosts + 900 + area * 100 + area * (2019 - constructionYear) * 5;
    }

}
