import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Dice dice = new Dice();
		dice.dice = new int[6];

		for(int i = 0;i < dice.dice.length;i++) {
			dice.dice[i] = sc.nextInt();
		}

		int q = sc.nextInt(); //質問数

		for(int i = 0;i < q;i++) {
			//上面
			int top = sc.nextInt();
			//前面
			int front = sc.nextInt();

//			System.out.println(top + " " + front);

			System.out.println(dice.checkRight(front, top,dice.dice));
		}

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

	public void roll() {
		int t = dice[1];
		dice[1] = dice[2];
		dice[2] = dice[4];
		dice[4] = dice[3];
		dice[3] = t;
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

	public int checkRight(int front,int top,int[] dice) {
		int[] temp = dice;
		while(true) {
			//System.out.println("縦に回す" + temp[0]);
			if(temp[0] == top) { //上面が一致するまで回す
				break;
			}
			rollEast();
			if(temp[0] == top) {
				break;
			}
			rollSouth();
		}
		while(true) {
			//System.out.println("横に回す" + temp[1]);
			if(temp[1] == front) {//前面が一致するまで回す
				break;
			}
			roll();
		}

		return temp[2];
	}
}
