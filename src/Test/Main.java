package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t , a, b, ccca, cccb;
        String s = sc.nextLine();
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            Map<Character, Integer> mp = new HashMap<>();
            ccca = a;
            cccb = b;
            for (int j = 0; j < s.length(); j++) {
                System.out.println(s);
                if (mp.get(s.charAt(j)) == null) {
                    mp.put(s.charAt(j), 1);
                } else {
                    mp.replace(s.charAt(j), mp.get(s.charAt(j)) + 1);
                }
            }
            for (Character pk : mp.keySet())
                System.out.println(pk + " " + mp.get(pk));
            if (mp.get('?') > a + b) {
                System.out.println(-1);
                continue;
            }

            int aToUse = 0;
            int bToUse = 0;
            int any = 0;

            for (int k = 0; k < s.length() / 2; k++) {
                char c1 = s.charAt(k);
                char c2 = s.charAt(s.length() - k - 1);
                if (c1 == '?' || c2 == '?') {
                    if (c1 == '?') {
                        if (c2 != '?') {
                            if (c2 == 'a') {
                                aToUse++;
                                s = s.substring(0, k) + 'a' + s.substring(k + 1);
                            } else {
                                s = s.substring(0, k) + 'b' + s.substring(k + 1);
                                bToUse++;
                            }
                        } else {
                            if (a > 1) {
                                a -= 2;
                                s = s.substring(0, k) + 'a' + s.substring(k + 1, s.length() - k - 1) + 'a' + s.substring(s.length() - k);
                            } else if (b > 1) {
                                s = s.substring(0, k) + 'b' + s.substring(k + 1, s.length() - k - 1) + 'b' + s.substring(s.length() - k);
                            }
                            any += 2;
                        }
                    } else {
                        if (c1 == 'a') {
                            s = s.substring(0, k) + 'a' + s.substring(k + 1);
                            aToUse++;
                        } else {
                            s = s.substring(0, k) + 'b' + s.substring(k + 1);
                            bToUse++;
                        }
                    }
                }
            }
            int cpa = ccca, cpb = cccb;

            while (ccca > 1 && any > 0) {
                any -= 2;
                ccca -= 2;
            }

            while (cccb > 1 && any > 0) {
                any -= 2;
                cccb -= 2;
            }

            if (aToUse < cpa && bToUse < cpb && any == 0) {
                System.out.println(s);
            } else {
                System.out.println(-1);
            }

        }

    }
}
