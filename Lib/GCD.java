import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

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

