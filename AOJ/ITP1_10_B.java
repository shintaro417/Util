import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//辺の長さ
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		//角度
		int c = sc.nextInt();

		//面積を求める
		double s = squareCalc(a, b, c);

		//辺の長さを求める
		double d = cosineTheorem(a, b, c);

		//周の長さ
		double L = d + a + b;

		//高さを求める
		double height = heightCalc(a, s);

		System.out.println(s);
		System.out.println(L);
		System.out.println(height);


		sc.close();
	}

	/**
	 * 2点間の距離を求めるメソッド
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return double
	 */
	public static double distance(double x1,double y1,double x2,double y2) {
		double distance = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);

		return Math.sqrt(distance);
	}

	/**
	 * 余弦定理のメソッド
	 * @param a　辺の長さ
	 * @param b　辺の長さ
	 * @param c　角度
	 * @return　対辺の長さ
	 */
	public static double cosineTheorem(double a,double b,double c) {
		double d = Math.pow(a, 2) + Math.pow(b, 2) - 2.0 * a * b * Math.cos(Math.toRadians(c));
		return Math.sqrt(d);
	}

	/**
	 * 2辺と間の角から面積を求めるメソッド
	 * @param a 辺の長さ
	 * @param b 辺の長さ
	 * @param c 間の角度
	 * @return 面積
	 */
	public static double squareCalc(double a, double b, double c) {
		return 0.5 * a * b * Math.sin(Math.toRadians(c));
	}

	/**
	 * aを底辺として高さを求めるメソッド
	 * @param a　底辺
	 * @param s　面積
	 * @return 高さ
	 */
	public static double heightCalc(double a,double s) {
		return 2.0 * s / a;
	}


}
