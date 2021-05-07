import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			//中間試験の点数
			int m = sc.nextInt();
			//期末試験の点数
			int f = sc.nextInt();
			//再試験の点数
			int r = sc.nextInt();

			if(m + f + r == -3) {
				break;
			}

			if(m == -1 || f == -1) {
				System.out.println("F");
			}
			else if(m + f >= 80) {
				System.out.println("A");
			}else if(m + f >= 65) {
				System.out.println("B");
			}else if(m + f >= 50) {
				System.out.println("C");
			}else if(m + f >= 30 && r >= 50) {
				System.out.println("C");
			}else if(m + f >= 30) {
				System.out.println("D");
			}else {
				System.out.println("F");
			}
		}


		sc.close();
	}
}
