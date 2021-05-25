import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int n = sc.nextInt();
			double[] score = new double[n];
			if(n == 0) {
				break;
			}
			double sum = 0;


			for(int i = 0;i < n;i++) {
				score[i] = sc.nextDouble();
				sum += score[i];
			}
			double avg = sum / (double)n;

			double standardDeviation = standardDeviationCalc(avg, n, score);

			System.out.println(standardDeviation);
		}

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
