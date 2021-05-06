import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//x座標
		int w = sc.nextInt();
		//Y座標
		int h = sc.nextInt();
		//円の中心のx座標
		int x = sc.nextInt();
		//円の中心のy座標
		int y = sc.nextInt();
		//半径
		int r = sc.nextInt();

		boolean flag = false;

		if(x > 0 && y > 0) {
			//座標と半径を足して長方形の座標を超えない
			if((y + r <= h) && (x + r <= w)) {
				flag = true;
			}
		}

		if(flag) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		sc.close();
	}

}
