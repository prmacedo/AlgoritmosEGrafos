package Questao02;

import java.math.BigInteger;

public class MultiplicationOfInteger {
    public static String bruteForceSolution(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int multiplication = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = multiplication + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.isEmpty() && num == 0)) {
                sb.append(num);
            }
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static BigInteger karatsuba(BigInteger num1, BigInteger num2) {
        if (num1.compareTo(BigInteger.TEN) < 0 || num2.compareTo(BigInteger.TEN) < 0) {
            return num1.multiply(num2);
        }

        int n = Math.max(num1.bitLength(), num2.bitLength());
        int m = n / 2;

        BigInteger[] num1Parts = num1.divideAndRemainder(BigInteger.ONE.shiftLeft(m));
        BigInteger p = num1Parts[0];
        BigInteger q = num1Parts[1];

        BigInteger[] num2Parts = num2.divideAndRemainder(BigInteger.ONE.shiftLeft(m));
        BigInteger r = num2Parts[0];
        BigInteger s = num2Parts[1];

        BigInteger qs = karatsuba(q, s); // z0
        BigInteger y = karatsuba(q.add(p), s.add(r)); // z1
        BigInteger pr = karatsuba(p, r); // z2

        return pr.shiftLeft(2 * m).add(y.subtract(pr).subtract(qs).shiftLeft(m)).add(qs);
    }
}
