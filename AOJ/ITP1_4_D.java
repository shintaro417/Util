import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//整数の数
		int n = sc.nextInt();

		//合計
		long sum = 0;
		//最大値
		int max = -1000000;
		//最小値
		int min = 1000000;

		for(int i = 0;i < n;i++) {
			int a = sc.nextInt();
			sum = sum + a;
			if(max < a) {
				max = a;
			}

			if(min > a) {
				min = a;
			}
		}

		System.out.printf("%d %d %d\n", min,max,sum);

		sc.close();
	}
}
