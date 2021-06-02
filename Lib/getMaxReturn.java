mport java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sc.close();
	}

	/**
	 * 最大の利益を得るメソッド
	 * このやり方だと計算量がO(n**2)のため速度が間に合わない
	 */
//	public static int getMaxReturn(int[] price) {
//		int max = price[1] - price[0];
//
//		for(int i = 0;i < price.length - 1;i++) {
//			//System.out.println("price[i]:" + i + " " + price[i]);
//			for(int j = i + 1;j < price.length;j++) {
//
//				//System.out.println("price[j]:"  + j + " "+ price[j]);
//				max = Math.max(max, price[j] - price[i]);
//				//System.out.println("max:" + max);
//			}
//		}
//		return max;
//	}

	/**
	 * 投資利益の最大値を求めるメソッド
	 * iを増やす過程で、それ以前のRiの最小値(minv)を保持することで、
	 * 時刻iにおける最大利益をfor文1回で求めることができる。
	 * @param price
	 * @return
	 */
	public static int getMaxReturn(int[] price) {
		int minv = price[0]; //それまでの最小の値
		int maxv = price[1] - price[0];
		for(int i = 1;i < price.length;i++) {
			maxv = Math.max(maxv,price[i] - minv); //現在の最大値と今回対象の値から最小値を引いた値のどちらが大きいか比べて更新する
			minv = Math.min(minv, price[i]); //探索した値までに出てくる最小の値
		}

		return maxv;
	}
}

