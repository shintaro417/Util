import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//最初に持っているカードの枚数
		int n = sc.nextInt();

		//S = 0,H = 1,C = 2,D = 3
		boolean[][] card = new boolean[4][13];

		for(int i = 0;i < 4;i++) {
			for(int j = 0; j < 13;j++) {
				card[i][j]= false;
			}
		}

		for(int i = 0;i < n;i++) {
			//カードの種類
			char ch = sc.next().charAt(0);
			//カードのランク
			int r = sc.nextInt();

			if(ch == 'S') {
				card[0][r - 1] = true;
			}else if(ch == 'H') {
				card[1][r - 1] = true;
			}else if(ch == 'C') {
				card[2][r - 1] = true;
			}else if(ch == 'D') {
				card[3][r - 1] = true;
			}
		}

		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 13;j++) {
				if(!card[i][j]) {
					switch (i) {
					case 0:
						System.out.printf("S %d\n", j + 1);
						break;
					case 1:
						System.out.printf("H %d\n", j + 1);
						break;
					case 2:
						System.out.printf("C %d\n", j + 1);
						break;
					case 3:
						System.out.printf("D %d\n", j + 1);
						break;
				}
			}
		}
		}

		sc.close();
	}
}
