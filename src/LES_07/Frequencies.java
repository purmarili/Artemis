package LES_07;


import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Frequencies {
    static int b [] = new int[3];
    static int index = 0;

    static public boolean hasNext(){
        if (index < b.length){
            return true;
        }
        return false;
    }

    static public int next(){
        if (hasNext()){
            return b[index++];
        }
        return -1;
    }

    static int [] getKeys(){
        int [] a = new int[1];
        a[0] = b[0];
        return a;
    }

    public static List<String> getList(){
        return new ArrayList<>();
    }


    public static void main(String[] args) {


        String s = "HelloWorld Hey";

        List<String> lst = new ArrayList<>();
        String str = s.substring(0, 5);
        System.out.println(str);

        // ori ricxvis jamit migeba mesame ricxvis
        Scanner sc = new Scanner(System.in);
//        // [1, 5, 7, 8, 22, 33] 9
//        int first = 0, second = 0;
//
//
//
//        Map<Integer, Integer> mp = new HashMap<>();
//
//        int n = sc.nextInt();
//        int toGet = sc.nextInt();
//
//        int startIndex = 0, endIndex = 0;
//        for (int i=0; i<s.length(); i++){
//            if (s[i] == )
//        }

        // ori

//        for (int i=0; i<n; i++){
//            int k = sc.nextInt();
//            if (mp.get(k) == null)
//                mp.put(k, 1);
//            else mp.put(k, mp.get(k) + 1);
//        }
//
//        Iterator it = mp.keySet().iterator();
//
//        for (int i=0; i<mp.size(); i++){
//            first = (int) it.next();
//            if (mp.get(toGet - first) != null){
//                second = toGet - first;
//                break;
//            }
//        }
//
//        System.out.println(first + " " + second);

//        List<String> list;
//        list = getList();
//
//        b[0] = 1;
//        b[1] = 2;
//        b[2] = 3;

        // masivit amoxsna sixshireebis

//        int n = 10000;
//        int [] arr = new int[n];
//        int p = sc.nextInt();
//
//        for (int i=0; i<p; i++){
//            int k = sc.nextInt();
//            arr[k] += 1;
//        }
//        int max = 0;
//        for (int i=0; i<n; i++){
//            if (arr[i] > max)
//                max = arr[i];
//        }
//        System.out.println(max);

        // hashmapit amoxsna sixshireebis

//        Map<Integer, Integer> mp = new HashMap<>();
//
//
//        int n = sc.nextInt();
//        int k;
//
//        for (int i=0; i<n; i++){
//            k = sc.nextInt();
//            if (mp.get(k) == null)
//                mp.put(k, 1);
//            else mp.put(k, mp.get(k) + 1); // 1 2
//        }
//
//        Iterator it = mp.keySet().iterator();
//        int max = 0;
//        int maxNumber = 0;
//        for (int i=0; i<mp.size(); i++){
//            if (it.hasNext()){
//                int p = (int) it.next();
//                if (max < mp.get(p)){
//                    max = p;
//                    maxNumber = mp.get(max);
//                }
//            }
//        }
//        System.out.println(max + " " + maxNumber);

    }
}
