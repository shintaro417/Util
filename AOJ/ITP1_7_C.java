import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//表の行数
		int r = sc.nextInt();
		//列数
		int c = sc.nextInt();

		int[][] seat = new int[r][c];

		for(int i = 0;i < r;i++) {
			for(int j = 0;j < c;j++) {
				seat[i][j] = sc.nextInt();
			}
		}

		for(int i = 0;i < r;i++) {
			int sum = 0;
			for(int j = 0;j < c;j++) {
				sum += seat[i][j];
				System.out.printf("%d ", seat[i][j]);
			}
			System.out.println(sum);
		}

		int total = 0;
		for(int j = 0;j < c;j++) {
			int sum = 0;
			for(int i = 0;i < r;i++) {
				sum += seat[i][j];
			}
			System.out.printf("%d ", sum);
			total += sum;
		}
		System.out.println(total);
		sc.close();
	}
}
