import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	/**
	 * 挿入ソート　手持ちのトランプを並び替える時などに用いられるアルゴリズム
	 * 片手に持ったトランプを左から小さい順に並べる場合、1枚ずつカードを取り出して、それぞれの時点ですでにソートされている適切な位置へ挿入する
	 *
	 * ①先頭の要素をソート済みする
	 * ②未ソートの部分がなくなるまで以下の処理を繰り返す
	 * 1.未ソート部分の先頭から要素を一つ取り出してvに記録する
	 * 2.ソート済みの部分において、vより大きい要素を後方へ1つずつ移動する最後に空いた位置に「取り出した要素v」を挿入する
	 * @param a
	 * @param n
	 */
	public static void insertionSort(int[] a,int n) {
		for(int i = 1;i < n;i++) {
			int v = a[i]; //一時避難の変数
			int j = i  - 1;
			while(j >= 0 && a[j] > v) { //未ソートの先頭部分の値が、ソート済みの部分の値よりも小さいかどうかで判定する
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = v;
			for(int k = 0;k < n;k++) {
				if(k < a.length - 1) {
					System.out.print(a[k] + " ");
				}else {
					System.out.println(a[k]);
				}
			}
		}
	}

	public static void anotherSort(int[] a,int n) {
		for(int i = 1;i < n;i++) { //int i -> 未ソートの部分列の先頭を示すループ変数
			int j = i; //ソート済み部分列からvを挿入するための位置を探すループ変数
			while(j >= 1 && a[j - 1] > a[j]) { //ソート済みの部分列より未ソートの先頭の値が大きいかどうかを判定する。
				int temp = a[j]; //値を一時退避させる
				a[j] = a[j - 1]; //ソート済みの値を後にずらす
				a[j - 1] = temp; //退避させた値を挿入する
				j--; //値を引いて条件を満たす限り後にずらし続ける
			}
		}
	}
}

