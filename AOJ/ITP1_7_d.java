import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();

		//n * m -> a  m * l -> b

		int[][] a = new int[n][m];
		int[][] b = new int[m][l];

		for(int i = 0;i < n;i++) {
			for(int j = 0;j < m;j++) {
				a[i][j] = sc.nextInt();
			}
		}

		for(int i = 0;i < m;i++) {
			for(int j = 0;j < l;j++) {
				b[i][j] = sc.nextInt();
			}
		}

		long[][] c = new long[n][l];

		for(int i = 0;i < n;i++) {
			for(int j =0 ;j < l;j++) {
				for(int k = 0;k < m;k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
				if(j != l - 1) {
					System.out.printf("%d ", c[i][j]);
				}else {
					System.out.printf("%d", c[i][j]);
				}

			}

			System.out.println();
		}
		sc.close();
	}
}
