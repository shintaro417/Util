import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//情報の数
		int n = sc.nextInt();

		int[][][] loc = new int[4][3][10];

		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 3;j++) {
				for(int k = 0;k < 10;k++) {
					loc[i][j][k] = 0;
				}
			}
		}

		int count = 0;
		while(count < n) {
			//棟
			int b = sc.nextInt();
			//階
			int f = sc.nextInt();
			//部屋番号
			int r = sc.nextInt();
			//人数
			int v = sc.nextInt();

			loc[b - 1][f - 1][r - 1] += v;

			count++;
		}

		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 3;j++) {
				for(int k = 0;k < 10;k++) {
					System.out.printf(" %d",loc[i][j][k]);
				}
				System.out.println();
			}
			if(i != 3) {
				System.out.println("####################");
			}

		}
		sc.close();
	}
}
