import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int a = sc.nextInt();
			String opString = sc.next();
			int b = sc.nextInt();
			switch(opString) {
			case "+":
				System.out.printf("%d\n", a + b);
				break;
			case "-":
				System.out.printf("%d\n", a - b);
				break;
			case "*":
				System.out.printf("%d\n", a * b);
				break;
			case "/":
				System.out.printf("%d\n", a / b);
				break;
			default:
				break;
			}

			if(opString.equals("?")) {
				break;
			}
		}

		sc.close();
	}
}
