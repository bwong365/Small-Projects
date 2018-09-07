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

    /**
     * Let's try Bellard's formula
     * 2 ^6 x Summation of (n = 0; n < infinity; n++) (1^n / 2^10n ( - 2^5/(4n+1) - 1/(4n+3) + 2^8/(10n+1) - 2^6(10n+3) - 2^2(10n+5) - 2^2/(10n+7) + 1/(10n+9) )
     * Far quicker than the above (Taylor's)
     */
    public Double bellard(int iterations) {
        double pi = 0.0;
        for (int n = 0; n < iterations; n++) {
            double fr1 = pow(-1, n) / pow(2, 10 * n);
            double fr2 = pow(2, 5) / (4 * n + 1);
            double fr3 = 1.0 / (4 * n + 3);
            double fr4 = pow(2, 8) / (10 * n + 1);
            double fr5 = pow(2, 6) / (10 * n + 3);
            double fr6 = pow(2, 2) / (10 * n + 5);
            double fr7 = pow(2, 2) / (10 * n + 7);
            double fr8 = 1.0 / (10 * n + 9);
            pi += fr1 * (-fr2 - fr3 + fr4 - fr5 - fr6 - fr7 + fr8);
        }
        return pi / pow(2, 6);
    }

    /**
     * Big Decimal makes bellard's formula ridiculously accurate
     * 20000 iterations at scale 100 gives us 100 decimal places of accuracy
     * @return
     */
    public BigDecimal bellardbd(int iterations) {
        BigDecimal pi = new BigDecimal(0);
        for (int n = 0; n < iterations; n++) {
            BigDecimal fr1 = BigDecimal.valueOf(-1).pow(n).divide( (BigDecimal.valueOf(2).pow(10 * n)), 1000, RoundingMode.HALF_UP);
            BigDecimal fr2 = BigDecimal.valueOf(2).pow(5).divide(BigDecimal.valueOf(4 * n + 1), 1000, RoundingMode.HALF_UP);
            BigDecimal fr3 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(4 * n + 3), 1000, RoundingMode.HALF_UP);
            BigDecimal fr4 = BigDecimal.valueOf(2).pow(8).divide(BigDecimal.valueOf(10 * n + 1), 1000, RoundingMode.HALF_UP);
            BigDecimal fr5 = BigDecimal.valueOf(2).pow(6).divide(BigDecimal.valueOf(10 * n + 3), 1000, RoundingMode.HALF_UP);
            BigDecimal fr6 = BigDecimal.valueOf(2).pow(2).divide(BigDecimal.valueOf(10 * n + 5), 1000, RoundingMode.HALF_UP);
            BigDecimal fr7 = BigDecimal.valueOf(2).pow(2).divide(BigDecimal.valueOf(10 * n + 7), 1000, RoundingMode.HALF_UP);
            BigDecimal fr8 = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(10 * n + 9), 1000, RoundingMode.HALF_UP);

            pi = pi.add(fr1.multiply(BigDecimal.valueOf(0).subtract(fr2).subtract(fr3).add(fr4).subtract(fr5).subtract(fr6).subtract(fr7).add(fr8)));
        }
        return pi.divide(BigDecimal.valueOf(2).pow(6), 1000, RoundingMode.HALF_UP);
    }

    public Double pow(double num, int exponent) {
        double result = 1.0;

        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result *= num;
            }
        } else if (exponent < 0) {
            exponent *= -1;
            for (int i = 0; i < exponent; i++) {
                result *= num;
            }
            result = 1 / result;
        }

        return result;
    }
}
