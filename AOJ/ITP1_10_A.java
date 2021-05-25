import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();

		double distance = distance(x1, y1, x2, y2);

		System.out.println(distance);
		sc.close();
	}

	public static double distance(double x1,double y1,double x2,double y2) {
		double distance = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);

		return Math.sqrt(distance);
	}


}
