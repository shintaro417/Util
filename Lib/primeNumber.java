package aoj.itp1;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
	}

	/**
	 * 素数を判定するメソッド
	 * @param num
	 * @return true:素数 false:素数でない
	 */
	public static boolean isPrimeNumber(double num) {
		double numSqrt = Math.sqrt(num);

		if(num == 2) {
			return true;
		}

		if(num < 2 || num % 2 == 0) { //2以外の偶数は素数ではないのでfalseを返す
			return false;
		}

		int i = 3;
		//ある数nが素数かどうか判定するには「√n以下の素数で割り切れるかどうか」を確かめれば良い
		while(i <= numSqrt) {
			if(num % i == 0) {
				return false;
			}
			i += 2;
		}
		return true;

	}

}

