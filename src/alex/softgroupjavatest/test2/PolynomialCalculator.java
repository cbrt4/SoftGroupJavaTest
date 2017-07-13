package alex.softgroupjavatest.test2;

public class PolynomialCalculator {

    public String calculate(int a, int b, int n) {
        if (n == 0) return "(a+b)^0 = 1";
        int polynomial = (int) Math.pow((a + b), n);
        int r, num;
        String lastRow = "";
        String numbers = "";
        String pow1;
        String pow2;
        for (int i = 0; i <= n; i++) {
            num = 1;
            r = i + 1;
            for (int col = 0; col <= i; col++) {
                if (col > 0) {
                    num = num * (r - col) / col;
                }
                pow1 = n-col == 1 ? "" : "^" + String.valueOf(n-col);
                pow2 = col == 1 ? "" : "^" + String.valueOf(col);
                if (num == 1 && col == 0) numbers = "a^" + n + "+";
                if (col > 0 && col < i) numbers = num +
                        "*a" +
                        pow1 +
                        "*b" +
                        pow2 +
                        "+";
                if (num == 1 && col == i) numbers = "b^" + n;
                if (i == n) lastRow += numbers;
            }
        }
        lastRow += "=" + polynomial;
        return lastRow;
    }
}
