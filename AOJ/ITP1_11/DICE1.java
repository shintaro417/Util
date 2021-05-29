import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Dice dice = new Dice();
		dice.dice = new int[6];

		for(int i = 0;i < dice.dice.length;i++) {
			dice.dice[i] = sc.nextInt();
		}

		String orderString = sc.next();

		for(int i = 0;i < orderString.length();i++) {
			char ch = orderString.charAt(i);
			dice.move(ch);
		}
		System.out.println(dice.getTop());
		sc.close();
	}
}

/**
 * ダイスクラス
 * サイコロをロールする。
 */
class Dice{
	int[] dice;
	public Dice() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void rollEast() {
		int t = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[5];
		dice[5] = dice[2];
		dice[2] = t;
	}

	public void rollSouth() {
		int t = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[5];
		dice[5] = dice[1];
		dice[1] = t;
	}

	public void rollWest() {
		int t = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[5];
		dice[5] = dice[3];
		dice[3] = t;
	}

	public void rollNorth() {
		int t = dice[0];
		dice[0] = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[4];
		dice[4] = t;
	}

	public int getTop() {
		return dice[0];
	}
	public void move(char ch) {
		switch (ch){
		case 'E':
			rollEast();
			break;
		case 'S':
			rollSouth();
			break;
		case 'W':
			rollWest();
			break;
		case 'N':
			rollNorth();
			break;
		}
	}
}
