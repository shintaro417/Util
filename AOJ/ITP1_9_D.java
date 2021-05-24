import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		StringBuilder sBuilder = new StringBuilder(str);

		int q = sc.nextInt(); //命令数

		for(int i = 0;i < q;i++) {
			String qString = sc.next();

			int start = sc.nextInt();
			int end = sc.nextInt();

			if(qString.equals("replace")) {
				String replaceString = sc.next();

				sBuilder.replace(start, end + 1, replaceString);

				//System.out.println(sBuilder.toString());
			}else if(qString.equals("reverse")) {
				String reverseString = sBuilder.substring(start, end + 1);
				StringBuilder revereseBuilder = new StringBuilder(reverseString);

				sBuilder.replace(start, end + 1,revereseBuilder.reverse().toString());

				//System.out.println(sBuilder.toString());
			}else {
				System.out.println(sBuilder.substring(start, end + 1));
			}


		}

		sc.close();
	}


}
