import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//秒単位の時間
		int s = sc.nextInt();
		//時間
		int hour = s / 3600;
		//分
		int minute = (s % 3600) / 60;
		//秒
		int second = (s % 3600) % 60;

		System.out.println(hour + ":" + minute + ":" + second);

		sc.close();
	}

}
