import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i < 10;i++) {
			String string = sc.next(); //最初の文字列の並び
			if(string.equals("-")) {
				break;
			}

			int m = sc.nextInt();

			for(int j = 0; j < m;j++) {
				int h = sc.nextInt(); //移動させる枚数
				String aString = string.substring(0, h);
				String bString = string.substring(h, string.length());
				string = bString + aString;

			}
			System.out.println(string);
		}

		sc.close();
	}


}
