import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long n = sc.nextLong();
		//操作回数
		int k = sc.nextInt();

		for(int i = 0; i < k;i++) {
			if(n % 200 == 0) {
				n /= 200;
			}else {
				String nString = n + "200";
				n = Long.parseLong(nString);
			}
		}

		System.out.println(n);
		sc.close();
	}
}
