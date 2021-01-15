package LES_20;

import Homework.OpsOnLists.IntDoubleList;
import Homework.OpsOnLists.OpsOnLists;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

//        sortKind();
        IntDoubleList list = new IntDoubleList();
        int n = sc.nextInt();
        for (int i=0; i<n; i++){
            list.append(sc.nextInt());
        }
        System.out.println(list.toString());
        OpsOnLists.mixedList(list);
        System.out.println(list.toString());

    }

    private static void sortKind() {
        int n = sc.nextInt();
        int [] elems = new int[n];
        for (int i=0; i<n; i++){
            elems[i] = sc.nextInt();
        }
        int value = sc.nextInt();
        for (int i=1; i<elems.length; i++){
            if (elems[i] < value) {
                for (int j = i - 1; j > 0; j--) {
                    if (elems[j] >= value){
                        int temp = elems[j];
                        elems[j] = elems[j + 1];
                        elems[j + 1] = temp;
                    }else{
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(elems));
    }
}
