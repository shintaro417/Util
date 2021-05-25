import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
	}

	/**
	 * ミンコフスキー距離を計算するメソッド
	 * @param x 対象ベクトル
	 * @param y　対象ベクトル
	 * @param p 乗数(無限大の時はうまくいかない…)
	 * @return 計算結果
	 */
	public static double minkowskiDistance(double[] x,double[] y,double p) {
		double total = 0.0;
		double max = 0.0;

		for(int i = 0;i < x.length;i++) {
			total += Math.pow(Math.abs(x[i] - y[i]), p);
			max = Math.max(max, Math.abs(x[i] - y[i]));
		}

		if(Double.isInfinite(p)) {
			return max;
		}else {
			return Math.pow(total, 1.0 / p);
		}
	}
}
