import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double r = sc.nextDouble();

		double Circumference = r * 2 * Math.PI;
		double area = r * r * Math.PI;

		System.out.printf("%f %f\n", area,Circumference);

		sc.close();
	}

}
