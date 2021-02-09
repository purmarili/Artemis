package Hackerrank.ListTmp;

import Hackerrank.ReverseLinkedList.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // head { data : 1 next -> data : 2 next -> data : 3 next -> null }
//        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
//        head.next = new SinglyLinkedListNode(2);
//        head.next.next = new SinglyLinkedListNode(3);
//        head.next.next.next = new SinglyLinkedListNode(4);
//        while (head != null){
//            System.out.println(head.data);
//            head = head.next;
//        }

        int sizeX = sc.nextInt();
        int sizeY = sc.nextInt();
        ArrayList<ArrayList<Integer>> world = new ArrayList<>();
        for (int i=0; i<=sizeX; i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j=1; j<=sizeY; j++){
                tmp.add(i * sizeX + j);
            }
            world.add(tmp);
        }
        traverse(world, 3, 2);

    }


    public static void traverse(ArrayList<ArrayList<Integer>> world, int startX, int startY){
        boolean [][] been = new boolean[world.size()][world.get(0).size()];
        trav(world, startX, startY, been);
    }
    /*
     *
     *  1  2  3  4  5
     *  6  7  8  9  10
     *  11 12 13 14 15
     *  16 17 18 19 20
     *  21 22 23 24 25
     *
     * */
    public static void trav(ArrayList<ArrayList<Integer>> world, int startX, int startY, boolean[][] been){
        if (startX < 0 || startX >= world.size() || startY < 0 || startY >= world.get(0).size()){
            return;
        }
        if (been[startX][startY]) return;
        System.out.println(world.get(startX).get(startY));
        been[startX][startY] = true;
        trav(world, startX, startY - 1, been);
        trav(world, startX, startY + 1, been);
        trav(world, startX - 1, startY, been);
        trav(world, startX + 1, startY, been);
    }

}
