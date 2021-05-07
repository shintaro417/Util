import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int i = 1;
		while(true) {
			int x = i;
			if(x > n) {
				break;
			}
			if(x % 3 == 0) {
				System.out.printf(" %d",i);
			}else {
				while(true) {
					if(x % 10 == 3) {
						System.out.printf(" %d", i);
						break;
					}
					x /= 10;
					if(x == 0) {
						break;
					}
				}
			}
			i++;

		}
		System.out.println();
		sc.close();
	}
}
