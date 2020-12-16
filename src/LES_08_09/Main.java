package LES_08_09;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        SuperRobot superRobot = new AIRobot();
        AIRobot aiRobot = new AIRobot();

//        lst.add(robot);
//        lst.add(superRobot);
//        lst.add(aiRobot);

    }

    // me-3
    public void getFrequency(){
        Map<Character, Integer> mp = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i=0; i<s.length(); i++){
            if (mp.get(s.charAt(i)) == null){
                mp.put(s.charAt(i), 1);
                continue;
            }
            mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
        }
        // int char double byte short float long --> primitives

        for (Character key : mp.keySet()){
            System.out.println(key + " " + mp.get(key));
        }

    }

    // me-4
    public static void differentString(){
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String s = sc.nextLine();
            set.add(s);
        }

        for (String s : set){
            System.out.println(s);
        }
    }

    // me-2
    public static void separateStrings(){
        String s = "HeLLo Asjda L";
        int start = 0;
        int end = 1;
        ArrayList<String> lst = new ArrayList<>();
        for (int i=0; i<s.length(); i++){

            if (i == s.length() - 1){
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                    lst.add(Character.toString(s.charAt(i)));
                break;
            }

            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){

                start = i;
                for (int j = i + 1; j < s.length(); j++){

                    if (s.charAt(j) == ' ' || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')){
                        end = j;
                        lst.add(s.substring(start, end));
                        start = end;
                        end = end + 1;
                        i = start - 1;
                        break;
                    }
                }
            }

        }
        for (int i=0; i<lst.size(); i++){
            System.out.println(lst.get(i));
        }
    }
}

