import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
	}

	/**
	 * 標準偏差を求めるメソッド
	 * @param avg 平均値
	 * @param n　数値の個数
	 * @return 標準偏差
	 */
	public static double standardDeviationCalc(double avg,int n,double[] score) {
		double total = 0.0;
		for(int i = 0;i < n;i++) {
			total += Math.pow(score[i]- avg,2);
		}
		double distributed = total / (double)n; //分散
		return Math.sqrt(distributed);
	}




}
