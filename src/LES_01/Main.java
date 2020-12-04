package LES_01;

public class Main {
    public static void main(String[] args) {



    }

    public static void fibonacci() {
        int first = 0, second = 1;
        /*
        0 1 1
        1 1 2
        1 2 3
         */

        for (int i = 0; i < 10; i++){
            int third = first + second;
            System.out.println(third);
            first = second;
            second = third;
        }

    }

    public static void getAllNumbers(){

        for (int i = 100; i < 1000; i++){
            if (i % getDigitsSum(i) == 0){
                System.out.println(i);
            }
        }

    }

    public static int getDigitsSum(int number){

        int result = 0;

        while (number != 0){
            int digit = number % 10;
            result += digit;
            number /= 10;
        }

        return result;
    }

    public static void gcd(int first, int second){

        int gcd = 1;
        System.out.println("Enter two integers: ");

        for(int i = 1; i <= first && i <= second; i++) {
            if(first % i == 0 && second % i == 0)
                gcd = i;
        }

        System.out.println("G.C.D of " + first + " and " + second + " is: " + gcd);

    }

//    public static boolean isPrime(int number){
//
//        for (int i = 2; i < number / 2; i++){
//            if (number % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }

//    public static void fibonacci(){
//        int first = 0, second = 1, temp;
//        System.out.println(first + " " + second + " ");
//        for (int i = 0; i < 10; i++){
//            temp = first;
//            first = second;
//            second = temp + first;
//            System.out.println(second + " ");
//        }
//    }

    public static void allThreeDigits(){
        for (int i = 100; i < 100; i++){
            int temp = i, sum = 0;

            while (temp != 0) {
                sum += temp % 10;
                temp = temp/10;
            }

            if (i % sum == 0) {
                System.out.println(i + "\n");
            }
        }
    }

    public static void isPrime(int number){
        int half = number / 2;
        boolean isPrime = false;
        for (int i = 0; i < half; i++){
            if (number % i == 0){
                System.out.println(number + " is not Prime");
                return;
            }
        }
        System.out.println(number + " is Prime");
    }

    public static boolean hasThreeDigits(int number){
        number /= 100;
        if (number >= 1 && number < 10)
            return true;

        return false;
    }

    public static void afterZero(double number){
        int a = (int)number;
        double res = number - (double)a;
        System.out.println("Answer: " + res);
    }

    public static void upperCase(char ch){
        char res = (char) (ch - 32);
        System.out.println("Letter " + ch + " capitalised is: " + res);
    }

    public static void swapNumbers(int first, int second){
        System.out.println("Before swapping");
        System.out.println("value of x:" + first);
        System.out.println("value of y:" + second);
        System.out.println("After swapping");

        first = first + second;
        second = first - second;
        first = first - second;

        // using third variable

        int temp = first;
        first = second;
        second = temp;

        System.out.println("value of x:" + first);
        System.out.println("value of y:" + second);
    }

    public static Object sumTwoDigits(int number){
        number = 12;
        int a = number % 10;
        int b = number / 10;
        return a + b;
    }
}
