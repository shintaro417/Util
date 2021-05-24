import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int taroCnt = 0;
		int hanakoCnt = 0;

		for(int i = 0;i < n;i++) {
			String taroString = sc.next();
			String hanakoString = sc.next();

			if(taroString.compareTo(hanakoString) == 0) {
				taroCnt++;
				hanakoCnt++;
			}else if(taroString.compareTo(hanakoString) < 0) {
				hanakoCnt += 3;
			}else {
				taroCnt += 3;
			}
		}

		System.out.printf("%d %d\n", taroCnt,hanakoCnt);

		sc.close();
	}


}
