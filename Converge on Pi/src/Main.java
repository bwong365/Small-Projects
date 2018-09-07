import calc.CalculatePi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculatePi calc = new CalculatePi();
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("how many iterations? ");
        //int iters = Integer.parseInt(scanner.nextLine());
        System.out.println(calc.bellardbd(1));
        System.out.println(calc.bellardbd(200));
        System.out.println(calc.bellardbd(2000));
        System.out.println(calc.bellardbd(20000).subtract(calc.bellardbd(2000)));

    }
}
