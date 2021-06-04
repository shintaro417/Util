package aoj.itp1;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] a = new int[n];

		for(int i = 0;i < n;i++) {
			a[i] = sc.nextInt();
		}

		int ans = selectionSort(a, n);


		for(int i = 0;i < a.length;i++) {
			if(i == a.length - 1) {
				System.out.println(a[i]);
			}else {
				System.out.print(a[i] + " ");
			}
		}

		System.out.println(ans);

		sc.close();
	}


	/**
	 * 選択ソート
	 * n - 1回以下の処理を繰り返す
	 * 1.未ソートの部分から最小の要素の位置minjを特定する
	 * 2.minjの位置にある要素と未ソートの配列の先頭要素を交換する。
	 * @param a
	 * @param n
	 * @return　値が違って交換する回数
	 */
	public static int selectionSort(int[] a,int n) {

		int count = 0;

		//i 未ソート部分の配列の先頭を指すループ変数で、配列の先頭から末尾に向かって移動する。
		for(int i = 0;i < a.length;i++) {
			int minj = i; //minj 各ループ処理でi番目からn - 1番目までの要素で最小のものの位置。j未ソートの部分から最小値の位置(minj)を探すためのループ変数
			for(int j = i;j < a.length;j++) {
				if(a[j] < a[minj]) { //未ソートの部分列から最小値の位置を探す
					minj = j;
				}
			}
			if(a[i] > a[minj]) {
				count++;
			}
			//先頭要素a[i]と最小値の要素a[minj]を交換する
			int temp = a[i];
			a[i] = a[minj];
			a[minj] = temp;
		}

		return count;
	}
}

