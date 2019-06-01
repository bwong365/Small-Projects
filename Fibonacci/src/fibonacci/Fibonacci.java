package fibonacci;

import java.math.BigInteger;

public class Fibonacci {

    public static int sequence(int iterations) {
        int x = 0;
        int y = 1;
        System.out.print("0, ");
        for (int i = 0; i <= iterations - 1; i++) {
            System.out.print(y);
            if (i < iterations) System.out.print(", ");

            // summing the variables and subtracting the smaller number effectively moves x up to where y was
            y += x;
            x = y - x;

        }
        return y;
    }

    public static int recursive(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return recursive(n - 1) + recursive(n - 2);
    }

    public static BigInteger dynamic(int n) {
        BigInteger[] fibonacci = new BigInteger[n + 1];
        fibonacci[0] = BigInteger.valueOf(0);
        fibonacci[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
        }
        return fibonacci[n];
    }
}
