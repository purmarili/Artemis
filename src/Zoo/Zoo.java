package Zoo;

public class Zoo {

    private Vivarium[] vivaria;

    public Zoo(Vivarium[] vivaria){
        this.vivaria = vivaria;
    }

    public String toString(){
        // A pretty inefficient implementation.
        // One should rather use StringBuilder or StringBuffer.
        String res = "{";
        for(int i=0; i<vivaria.length; i++){
            res += vivaria[i].toString();
            if(i != vivaria.length - 1){
                res += ", ";
            } else {
                res += "}";
            }
        }
        return res;
    }

    public int getCosts(){
        int costs = 0;
        for(int i=0; i < vivaria.length; i++){
            costs += vivaria[i].getCosts();
        }
        return costs;
    }

}
