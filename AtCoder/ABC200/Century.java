import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();

		int y = 100;

		int count = 1;
		while(true) {
			if(year - y <= 0) {
				break;
			}
			y += 100;
			count++;
		}
		System.out.println(count);
		sc.close();
	}
}
