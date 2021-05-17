package aoj.itp1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {}


	/**
	 * 二項係数のメソッド
	 * @param n //全体の数
	 * @param k //nから選ぶ個数
	 * @return 計算結果
	 *
	 * メソッドの流れを理解しておくこと
	 */
	static long comb(int n, int k) {
        if(n < k) {
            int t = n;
            n = k;
            k = t;
        }
        if(k == 0) {
            return 1;
        }else if(n == k) {
            return 1;
        }else {
            return comb(n - 1, k - 1) * n / k;
        }
    }

}
