import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] ans = new int[3];

		for(int i = 0;i < ans.length;i++) {
			ans[i]= sc.nextInt();
		}

		int work;

		//隣あう数字を比較して昇順にソートするアルゴリズム
		//base_loc = 0 comp_loc = 2(ans.length - 1)
		//base_loc = 0 comp_loc = 1
		//base_loc = 1 comp_loc = 2
		for(int base_loc = 0; base_loc <= 1; base_loc++){
			for(int comp_loc = ans.length-1;comp_loc >= base_loc+1; comp_loc--){
				//配列の後から比較していく
				if(ans[comp_loc] < ans[comp_loc-1]){
					work = ans[comp_loc-1];
					ans[comp_loc-1] = ans[comp_loc];
					ans[comp_loc] = work;
				}
			}
		}

		for(int i = 0;i < ans.length;i++) {
			System.out.print(ans[i]);
			if(i < ans.length - 1) {
				System.out.print(" ");
			}
		}
		sc.close();
	}

}
