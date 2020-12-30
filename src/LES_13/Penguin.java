package LES_13;

public class Penguin extends MiniJava {

    // 0 -> land
    // 1 -> ice
    // 2 -> water
    // 3 -> shark
    // 4 -> fish
    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
        String res = "";
        for (int i=0; i<world.length; i++){
            for (int j=0; j<world[0].length; j++){
                if (world[i][j] == 0){
                    res += "L";
                }
                if (world[i][j] == 1){
                    res += "I";
                }
                if (world[i][j] == 2){
                    res += "W";
                }
                if (world[i][j] == 3){
                    res += "S";
                }
                if (world[i][j] == 4){
                    res += "F";
                }
                int count = 7;
                if (pinguRow == i && pinguColumn == j){
                    res += "(P)";
                    count = 4;
                }
                if (j != world[0].length - 1){
                    for (int p=0; p<count; p++){
                        res += " ";
                    }
                }
            }
            if (i != world.length - 1){
                res += "\n";
            }
        }
        System.out.println(res);
    }

    /*
                            T 1
             T 2         2         2          2
          T 3 3 3 3   3 3 3 3   3 3 3 3    3 3 3 3

    */

    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn){

        if (pinguRow < 0 || pinguColumn < 0 || pinguRow >= world.length || pinguColumn >= world[0].length) {
            return false;
        }
        if (world[pinguRow][pinguColumn] == 4) {
            return true;
        }
        if (world[pinguRow][pinguColumn] == 3) {
            return false;
        }

        if (world[pinguRow][pinguColumn] == 0) {
            world[pinguRow][pinguColumn] = 3;
            return (isFishReachable(world, pinguRow, pinguColumn - 1) ||
                    isFishReachable(world, pinguRow, pinguColumn + 1) ||
                    isFishReachable(world, pinguRow - 1, pinguColumn) ||
                    isFishReachable(world, pinguRow + 1, pinguColumn));
        }

        if (world[pinguRow][pinguColumn] == 1){
            world[pinguRow][pinguColumn] = 3;
            return (isFishReachable(world, pinguRow - 1, pinguColumn - 1) ||
                    isFishReachable(world, pinguRow - 1, pinguColumn + 1) ||
                    isFishReachable(world, pinguRow + 1, pinguColumn - 1) ||
                    isFishReachable(world, pinguRow + 1, pinguColumn + 1));
        }

        if (world[pinguRow][pinguColumn] == 2){
            world[pinguRow][pinguColumn] = 3;
            return (isFishReachable(world, pinguRow - 3, pinguColumn - 3) ||
                    isFishReachable(world, pinguRow - 3, pinguColumn + 3) ||
                    isFishReachable(world, pinguRow + 3, pinguColumn - 3) ||
                    isFishReachable(world, pinguRow + 3, pinguColumn + 3));
        }

        return false;
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     * @return An example world
     */
    public static int[][] generateExampleWorldOne(){
        return new int[][] {{2,3,3,3,3,3}, {3,0,3,3,4,3}, {3,3,3,3,3,1}, {3,3,3,0,1,3}, {3,3,3,3,3,3}};
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     * @return An example world
     */
    public static int[][] generateExampleWorldTwo(){
        return new int[][] {{0,0,0,2}, {0,0,0,1}, {0,1,3,4}, {3,4,3,3}};
    }

    /** 
     *  You may use the main method for testing your program.
     */
    public static void main(String[] args){
        int pinguRow = 0;
        int pinguColumn = 0;
        int[][] world = generateExampleWorldTwo();
        printWorld(world, pinguRow, pinguColumn);
        boolean p = isFishReachable(world, pinguRow, pinguColumn);
        if (p) System.out.println("Pingu reached the fish");
        else System.out.println("Pingu couldn't reach the fish");
    }

}
