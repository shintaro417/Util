import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String wString = sc.nextLine();

		int cnt = 0;

		while(true) {
			String t = sc.next();
			if(t.equals("END_OF_TEXT")) { //指定した文字列と完全一致(小文字、大文字を区別する)
				break;
			}else if(t.equalsIgnoreCase(wString)) { //指定した文字列と完全一致(小文字、大文字を区別しない)
				cnt++;
			}

		}

		System.out.println(cnt);

		sc.close();
	}


}
