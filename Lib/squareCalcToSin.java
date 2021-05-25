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
