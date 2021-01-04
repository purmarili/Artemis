package LES_15;

import java.util.Scanner;

public class Recursion {

    /*
      (0, 0) -> (0, 3)
        1 0 0 1
        1 1 1 1
        1 1 1 1
        1 0 1 1
     */

    public static void main(String[] args) {
        int [][] matrix = {{1, 0, 0, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 0, 1, 1}};
//        for (int i=0; i<matrix.length; i++){
//            String s = "";
//            for (int j=0; j<matrix[0].length; j++){
//                s += matrix[i][j] + " ";
//            }
//            System.out.println(s);
//        }
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        System.out.println(first / second);
//        try{
//            System.out.println(first / second);
//        }catch (ArithmeticException e){
//            System.out.println("nolze ricxvis gayofa ar sheidzleba");
//        }
        System.out.println("Hello");
//        System.out.println(getShortestPath(matrix, 0, 0, 0, 3));
    }

    private static int getShortestPath(int [][] matrix, int startX, int startY, int finalX, int finalY){

        return recursiveWalk(matrix, startX, startY, finalX, finalY, 0);
    }

    private static int recursiveWalk(int [][] matrix, int x, int y, int finalX, int finalY, int count){

        if (x == finalX && y == finalY) return count;

        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
            return Integer.MAX_VALUE;

        if (matrix[x][y] == 0) return Integer.MAX_VALUE;

        matrix[x][y] = 0;
        int first = recursiveWalk(matrix, x, y - 1, finalX, finalY, count + 1);
        int second = recursiveWalk(matrix, x, y + 1, finalX, finalY, count + 1);
        int third = recursiveWalk(matrix, x - 1, y, finalX, finalY, count + 1);
        int fourth = recursiveWalk(matrix, x + 1, y, finalX, finalY, count + 1);

        int min1 = Math.min(first, second);
        int min2 = Math.min(third, fourth);
        int res = Math.min(min1, min2);
        return res;
    }
}
/*
                                                    1(1+)(2)
                           2(1+)(2)                2(2+)(17)             2(3+)(1)           2(4+)(9)
           3(1+)(5)  3(2+)(10)  3(3+)(2)  3(4+)(8)                      3  3  3  3      3  3  3  3

                  4(1+)(3) 4(2+)(2) 4(3+)(5) 4(4+)(7)
 */