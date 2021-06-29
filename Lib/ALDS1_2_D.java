import java.util.Scanner;

public class Main {
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		cnt = 0;
		int n = sc.nextInt(); //整数の個数
		int[] a = new int[n];

		for(int i = 0;i < n;i++) {
			a[i] = sc.nextInt();
		}

		shellSort(a, n);


		System.out.println(cnt);

		for(int num : a) {
			System.out.println(num);
		}

		sc.close();
	}

	public static void insertionSort(int[] a,int n,int g) {
		int v,j;
		for(int i = g;i < n;i++) {
			v = a[i];
			j = i - g;
			while(j >= 0 && a[j] > v) {
				a[j + g] = a[j];
				j = j - g;
				cnt++;
			}
			a[j + g] = v;
		}
	}

	/**
	 * シェルソート：挿入ソートの改良版
	 * 一定の間隔で挿入ソートを実行する
	 * @param a 整列対象の配列
	 * @param n 要素数
	 */
	public static void shellSort(int[] a,int n) {
		int[] G = new int[15];//整列間隔を格納した配列
		int h = 1;
		int m = 0; //間隔の数
		//シェルソートにおける間隔は3hi + 1の間隔がベター
		for(int i = 1;i <= n;i = i * 3 + 1) {
			G[m] = i;
			m++;
		}

		System.out.println(m);

		for(int i = m - 1;i >= 0;i--) {
			System.out.print((i == m - 1 ? "" : " ") + G[i] + (i == 0 ? "\n" : ""));
		}

		for(int i = m - 1;i >= 0;i--) {
			insertionSort(a, n, G[i]);
		}
	}
}

