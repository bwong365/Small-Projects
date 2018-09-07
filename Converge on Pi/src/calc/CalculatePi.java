package calc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatePi {

    public CalculatePi() {

    }

    /**
     * // I guess we'll start with the simplest convergence
     *     // 4/1 - 4/3 + 4/5 - 4/7 + 4/9...
     *  two billion iterations gets us to 10 millionths accuracy
     */
    public Double basicSeries() {
        int numerator = 4;
        int denominator = 1;
        // on for plus, off for minus
        boolean plusOrMinus = true;
        double pi = 0.0;

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

    /**
     * Staying with the simple method, as I explore how to use BigDecimal.
     * At least for this method, BigDecimal adds a decimal point of additional
     * while increasing the timeframe by an absurd amount
     */
    public BigDecimal basicSeriesBd() {
        BigDecimal numerator = new BigDecimal("4.00000000000000000000000");
        BigDecimal denominator = new BigDecimal(1.0);
        // on for plus, off for minus
        boolean plusOrMinus = true;
        BigDecimal pi = new BigDecimal(0.0);

        // we swap the operator and increase the denominator each time
        for (int i = 0; i < 2000000000; i++) {
            BigDecimal fr = numerator.divide(denominator, RoundingMode.HALF_UP);

            if (plusOrMinus) {
                pi = pi.add(fr);
                plusOrMinus = false;
            } else {
                pi = pi.subtract(fr);
                plusOrMinus = true;
            }

            denominator = denominator.add(BigDecimal.valueOf(2));
        }

        return pi;
    }
}
