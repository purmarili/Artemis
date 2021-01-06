package LES_16;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Fast {
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size = 1000;
        int [] arr = new int[size];
        for (int i=0; i<size; i++){
            arr[i] = rand.nextInt(100000);
        }
        sortArr(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, arr[768]));
    }

    private static void sortArr(int[] arr) {
        for (int i=0; i<arr.length; i++){
            int index = i;
            int min = arr[i];
            for (int j=i; j<arr.length; j++){
                if (arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
        }
    }

    private static int binarySearch(int [] arr, int number){
        int operations = 0;
        int res = -1;
        int start = 0;
        int end = arr.length - 1;
        int mid = start + end / 2;
        while (start <= end){
            operations++;
            if (arr[mid] == number){
                System.out.println(operations);
                return mid;
            }
            if (number > arr[mid]){
                start = mid;
                mid = (start + end) / 2;
            }else if (number < arr[mid]){
                end = mid;
                mid = (start + end) / 2;
            }
        }
        return res;
    }
}
