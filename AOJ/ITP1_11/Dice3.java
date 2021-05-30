import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Dice dice1 = new Dice();
		Dice dice2 = new Dice();

		for(int i = 0;i < dice1.dice.length;i++) {
			dice1.dice[i] = sc.nextInt();
		}

		for(int i = 0;i < dice2.dice.length;i++) {
			dice2.dice[i] = sc.nextInt();
		}

		if(sameDice(dice1, dice2)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}



		sc.close();
	}


	/**
	 * どちらのダイスもラベル6が上面になるように設定して、dice2を右に回し続けて一致するかどうかを調べる。
	 * @param dice1
	 * @param dice2
	 * @return 2つのダイスが一致しているか否かを確かめる
	 */
	static boolean sameDice(Dice dice1,Dice dice2) {
		dice1.moveTop();
		dice2.moveTop();

		boolean flag = true;
		for(int i = 0;i < 4;i++) {

			//確認用
			System.out.println("dice1" + Arrays.toString(dice1.dice));
			System.out.println("dice2" + Arrays.toString(dice2.dice));

			for(int j = 1;j < dice1.dice.length;j++) {
				if(dice1.dice[j] != dice2.dice[j]) {
					flag = false;
					break;
				}else {
					flag = true;
				}
			}
			if(flag) {
				return flag;
			}
			dice2.rollRight();
		}

		return flag;
	}
}

/**
 * ダイスクラス
 * サイコロをロールする。
 */
class Dice{
	int[] dice = new int[6];
	public Dice() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//ダイスを東の方向に倒す
	public void rollEast() {
		int t = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[5];
		dice[5] = dice[2];
		dice[2] = t;
	}

	//ダイスを南の方向に倒す
	public void rollSouth() {
		int t = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[5];
		dice[5] = dice[1];
		dice[1] = t;
	}

	//ダイスを西の方向に倒す
	public void rollWest() {
		int t = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[5];
		dice[5] = dice[3];
		dice[3] = t;
	}

	//ダイスを北の方向に倒す
	public void rollNorth() {
		int t = dice[0];
		dice[0] = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[4];
		dice[4] = t;
	}

	//ダイスを右回りさせる。
	public void rollRight() {
		int t = dice[1];
		dice[1] = dice[2];
		dice[2] = dice[4];
		dice[4] = dice[3];
		dice[3] = t;
	}

	//ダイスの上面を取得する
	public int getTop() {
		return dice[0];
	}


	/**
	 * 入力値によってダイスを動かす
	 * @param ch
	 */
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


	/**
	 * 前面と上面を固定した時の右側にある数字を出力する
	 * @param front
	 * @param top
	 * @param dice
	 * @return 右側にある数字
	 */
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
			rollRight();
		}

		return temp[2];
	}

	//ラベル6を上面に持っていく処理
	public void moveTop() {
		int temp = dice[5];
		while(true) {
			if(dice[0] == temp) {
				break;
			}
			rollEast();
			if(dice[0] == temp) {
				break;
			}
			rollNorth();
		}
	}

}
