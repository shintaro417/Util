import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			while(true) {
				 String n = sc.nextLine();
				if(n.equals("0")) {
//					System.out.println();
					break;
				}

				long sum = 0;
				for(int i = 0;i < n.length();i++) {
					char ch = n.charAt(i);
					int num = Character.getNumericValue(ch);
					sum += num;
				}
				System.out.println(sum);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


		sc.close();
	}
}
