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

    public static long karatsuba(long num1, long num2) {
        if (num1 < 10 || num2 < 10) {
            return num1 * num2;
        }

        int n = Math.max(String.valueOf(num1).length(), String.valueOf(num2).length());
        int m = (n + 1) / 2;

        long power = (long) Math.pow(10, m);

        long p = num1 / power;
        long q = num1 % power;
        long r = num2 / power;
        long s = num2 % power;

        long pr = karatsuba(p, r);
        long qs = karatsuba(q, s);
        long y = karatsuba(p + q, r + s);

        return pr * power * power + (y - pr - qs) * power + qs;
    }
}
