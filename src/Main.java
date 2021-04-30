public class Main {

    public static void main(String[] args) {
        System.out.println("Пример 1.\n" + "291 * 336 = " + karatsuba(291, 336));
        System.out.println("Пример 2.\n" + "25 * 97 = " + karatsuba(25, 97));
        System.out.println("Пример 3.\n" + "3 * 9 = " + karatsuba(3, 9));
        System.out.println("Пример 4.\n" + "4381 * 7034 = " + karatsuba(4381, 7034));
        System.out.println("Пример 5.\n" + "10536 * 19732 = " + karatsuba(10536, 19732));
        System.out.println("Пример 6.\n" + "379829 * 564822 = " + karatsuba(379829, 564822));
    }

    private static long karatsuba(long x, long y) {
        if (x < 10 && y < 10) {
            return x * y;
        }

        int n = Math.max(Long.valueOf(x).toString().length(), (Long.valueOf(y).toString().length()));
        int m = n / 2 + n % 2;

        long a = x / (long) Math.pow(10, m);
        long b = x % (long) Math.pow(10, m);
        long c = y / (long) Math.pow(10, m);
        long d = y % (long) Math.pow(10, m);
        long step1 = karatsuba(a, c);
        long step2 = karatsuba(b, d);
        long step3 = karatsuba(a + b, c + d);
        long step4 = step3 - step2 - step1;
        long step5 = step1 * (long) Math.pow(10, m * 2) + step2 + step4 * (long) Math.pow(10, m);
        return step5;
    }
}