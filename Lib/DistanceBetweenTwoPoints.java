import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static double distance(double x1,double y1,double x2,double y2) {
		double distance = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);

		return Math.sqrt(distance);
	}


}
