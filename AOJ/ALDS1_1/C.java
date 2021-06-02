import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();


		int ans = 0;

		for(int i = 0;i < n;i++) {
			int num = sc.nextInt();
			if(isPrimeNumber(num)) {
				ans++;
			}
		}

		System.out.println(ans);


		sc.close();
	}

	public static boolean isPrimeNumber(double num) {
		double numSqrt = Math.sqrt(num);

		if(num == 2) {
			return true;
		}

		if(num < 2 || num % 2 == 0) {
			return false;
		}

		int i = 3;
		while(i <= numSqrt) {
			if(num % i == 0) {
				return false;
			}
			i += 2;
		}
		return true;

	}

	/**
	 * 最大公約数を求めるメソッド
	 * @param x
	 * @param y
	 * @return 最大公約数
	 */
	public static int gcd(int x,int y) {
		int gcd = 0;
		int r = 0;
		if(x >= y) {
			while(true) {
				r = x % y;
				if(r == 0) {
					gcd = y;
					break;
				}
				x = y;
				y = r;
			}
		}else {
			while(true) {
				r = y % x;
				if(r == 0) {
					gcd = x;
					break;
				}
				y = x;
				x = r;
			}
		}
		return gcd;
	}
}

