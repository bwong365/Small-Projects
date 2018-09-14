package fibonacci;

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
}
