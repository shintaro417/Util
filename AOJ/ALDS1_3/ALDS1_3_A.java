package aoj.itp1;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Integer> stack = new Stack<Integer>();
		String str = sc.nextLine();
		String[] lines = str.split(" ");

		for(String line : lines) {

			if(isInteger(line)) {
				stack.push(Integer.parseInt(line));
			}else {
				Calc(stack, line);
			}
		}

		System.out.println(stack.peek());

		sc.close();
	}

	public static void Calc(Stack<Integer> stack,String str) {
		switch (str){
		case "+":
			int numPlus = stack.pop();
			stack.push(stack.pop() + numPlus);
			break;
		case "-":
			int numMinus = stack.pop();
			stack.push(stack.pop() - numMinus);
			break;
		case "*":
			int numTimes = stack.pop();
			stack.push(stack.pop() * numTimes);
			break;
		case "/":
			int numDivide = stack.pop();
			stack.push(stack.pop() / numDivide);
			break;
		default:
			break;
		}
	}

	public static boolean isInteger(String str) {
		String regex = "^[0-9]*$";
	    Pattern p = Pattern.compile(regex);
	    Matcher m = p.matcher(str);
	    return m.find();
	}
}

