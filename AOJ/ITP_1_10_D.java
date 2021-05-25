import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		double[] x = new double[n];
		double[] y = new double[n];

		for(int i = 0;i < n;i++) {
			x[i]= sc.nextDouble();
		}
		for(int i = 0;i < n;i++) {
			y[i] = sc.nextDouble();
		}

		System.out.println(minkowskiDistance(x, y, 1));
		System.out.println(minkowskiDistance(x, y, 2));
		System.out.println(minkowskiDistance(x, y, 3));
		System.out.println(minkowskiDistance(x, y, Double.POSITIVE_INFINITY));

		sc.close();
	}

	/**
	 * ミンコフスキー距離を計算するメソッド
	 * @param x 対象ベクトル
	 * @param y　対象ベクトル
	 * @param p 次元数
	 * @return
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
