package calc;

public class CalculatePi {
    // I guess we'll start with the simplest convergence
    // 4/1 - 4/3 + 4/5 - 4/7 + 4/9...
    int numerator;
    int denominator;

    // on for plus, off for minus
    boolean plusOrMinus;

    public CalculatePi() {
        numerator = 4;
        denominator = 1;
        plusOrMinus = true;
    }

    public Double basicSeries() {
        double pi = 0.0;

        // two billion iterations gets us to 10 millionths accuracy
        // we swap the operator and increase the denominator each time
        for (int i = 0; i < 2000000000; i++) {
            double fr = numerator/(double) denominator;

            if (plusOrMinus) {
                pi += fr;
                plusOrMinus = false;
            } else {
                pi -= fr;
                plusOrMinus = true;
            }

            denominator += 2;
        }

        return pi;
    }
}
