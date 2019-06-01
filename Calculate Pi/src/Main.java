import calc.CalculatePi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculatePi calc = new CalculatePi();
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("how many iterations? ");
        //int iters = Integer.parseInt(scanner.nextLine());
        System.out.println(calc.bellardbd(10));
        System.out.println(calc.bellardbd(200));
    }
}
