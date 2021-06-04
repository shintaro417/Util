package aoj.itp1;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
	}

	/**
	 * バブルソートのメソッド
	 * 1.バブルソートでは、挿入ソートと同様に各計算ステップにおいて、配列は「ソート済みの部分列」と「未ソートの部分列」
	 * 2.順番が逆になっている隣接要素がなくなるまで、3の処理を繰り返す
	 * 3.配列の末尾から隣接する要素を順番に比べて、大小関係が逆なら交換する
	 * @param a
	 * @param n
	 * @return 交換回数
	 */
	public static int bubbleSort(int[] a,int n) {
		boolean flag = true;
		int count = 0;
		int i = 0; //未ソートの配列の先頭要素

		while(flag) {
			flag = false;

			//配列の末尾から順番に数を比較して比べていく
			for(int j = a.length - 1;j >= i + 1;j--) {
				if(a[j] < a[j - 1]) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
					count++;
					flag = true; //ループの継続を示すフラグ
				}

			}
			i++; //未ソート部分の配列の先頭要素をたしこむ
		}
		return count;
	}
}

