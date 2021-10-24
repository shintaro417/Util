// nCr を計算する。
    // 計算結果は int max を超えやすいので long 型としている。
    // long 型を超えそうな場合は BigInteger を使用する。
    public static long calcCombination(int n, int r) {
        if (n < 0 || r < 0) {
            throw new IllegalArgumentException("Arguments must be 0 and over.");
        }
        else if (n == r || r == 0) {
            return 1;
        }
        else if (n < r) {
            return 0;
        }
        else {
            long result = 1;
            for (int i = 1; i <= r; i++) {
                result = result * (n - i + 1) / i;
            }
            return result;
        }
    }
