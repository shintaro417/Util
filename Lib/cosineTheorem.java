import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		sc.close();
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


}
