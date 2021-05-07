import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			//上限の数
			int n = sc.nextInt();
			//目標合計値
			int x = sc.nextInt();

			if(n == 0 && x == 0) {
				break;
			}

			int ans = 0;

			for(int i = 1;i <= n;i++) {
				for(int j = i + 1;j <= n;j++) {
					for(int k = j + 1;k <= n;k++) {
						if(i == j || i == k || j == k) {
							continue;
						}

						if(x == i + j + k) {
							ans++;
						}
					}
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
