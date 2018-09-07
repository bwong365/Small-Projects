public class Fibonacci {

    public static void sequence(int iterations) {
        int x = 0;
        int y = 1;
        System.out.print("0, ");
        for (int i = 0; i <= iterations; i++) {
            System.out.print(y);
            if (i < iterations) System.out.print(", ");
            y += x;
            x = y - x;

        }
    }
}
