import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] ans = new int[3];

		for(int i = 0;i < ans.length;i++) {
			ans[i]= sc.nextInt();
		}

		Arrays.sort(ans);

		//出力に注意
		for(int i = 0;i < ans.length;i++) {
			System.out.print(ans[i]);
			if(i < ans.length - 1) {
				System.out.print(" ");
			}
		}
		sc.close();
	}

}
