package Hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArays {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        n = sc.nextInt();
        String[] strings = new String[n+1];
        for (int i = 0; i <= n; i++) {
            strings[i] = sc.nextLine();
        }
        int q = Integer.parseInt(sc.nextLine());
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextLine();
        }
        int[] res = matchingStrings(strings, queries);
        System.out.println(Arrays.toString(res));
    }

    public static int[] matchingStrings(String[] strings, String[] queries) {
        int[] res = new int[queries.length];
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (mp.get(strings[i]) == null) mp.put(strings[i], 1);
            else mp.put(strings[i], mp.get(strings[i]) + 1);
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = mp.get(queries[i]) == null ? 0 : mp.get(queries[i]);
        }
        return res;
    }
}
