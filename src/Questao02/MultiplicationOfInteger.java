package Questao02;

public class MultiplicationOfInteger {
    public static String bruteForceSolution(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int multiplication = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int soma = multiplication + result[i + j + 1];

                result[i + j + 1] = soma % 10;
                result[i + j] += soma / 10;
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
        int m = n / 2;

        double aux = Math.pow(10, m);

        long p = (long) (num1 / aux);
        long q = (long) (num1 % aux);
        long r = (long) (num2 / aux);
        long s = (long) (num2 % aux);

        long pr = karatsuba(p, r);
        long qs = karatsuba(q, s);
        long y = karatsuba(p + q, r + s);

        return (long) (pr * aux * aux + (y - pr - qs) * aux + qs);
    }
}
