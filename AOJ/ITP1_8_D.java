import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String string = sc.nextLine();
		String p = sc.nextLine();
		StringBuilder sbString = new StringBuilder(string);
		boolean flag = false;
		for(int i = 0;i < string.length();i++) {
			if(sbString.indexOf(p) >= 0 ) {
				flag = true;
				break;
			}
			//先頭の文字を抽出
			String cutString = sbString.substring(0, 1);
			//先頭の文字を削除
			sbString = sbString.delete(0, 1);
			//抽出した文字を末尾へ連結
			sbString = sbString.insert(sbString.length(), cutString);
		}

		if(flag) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}

		sc.close();
	}


}
