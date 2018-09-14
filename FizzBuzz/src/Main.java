/**
 * We're going to create a silly program that prints the numbers from 1 to 100
 * for multiples of three, we'll print Fizz, and for multiples of five we'll print Buzz
 * for multiples of both three and five, we'll print FizzBuzz
 */
public class Main {
    public static void main(String[] args){
        String f = "Fizz";
        String b = "Buzz";

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(f + b);
            } else if (i % 3 == 0) {
                System.out.println(f);
            } else if (i % 5 == 0) {
                System.out.println(b);
            } else {
                System.out.println(Integer.toString(i));
            }
        }
    }

}
