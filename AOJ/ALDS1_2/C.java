package aoj.itp1;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String[] cardStrings = new String[n];
		for(int i = 0;i < n;i++) {
			cardStrings[i] = sc.next();
		}

		String[] bubbleArray = bubbleSort(cardStrings, n);
		String[] selectionArray = selectionSort(cardStrings, n);

		for(int i = 0;i < bubbleArray.length;i++) {
			if(i < bubbleArray.length - 1) {
				System.out.print(bubbleArray[i] + " ");
			}else {
				System.out.println(bubbleArray[i]);
			}
		}

		System.out.println("Stable");

		for(int i = 0;i < selectionArray.length;i++) {
			if(i < selectionArray.length - 1) {
				System.out.print(selectionArray[i] + " ");
			}else {
				System.out.println(selectionArray[i]);
			}
		}

		if(isStable(bubbleArray, selectionArray)) {
			System.out.println("Stable");
		}else {
			System.out.println("Not stable");
		}

		sc.close();
	}

	public static String[] bubbleSort(String[] card,int n) {
		String[] bubbleArray = card.clone();
		for(int i = 0;i < n;i++) {
			for(int j = n - 1;j >= i + 1;j--) { //末尾から大小関係を比較する
				if((int)bubbleArray[j].charAt(1) < (int)bubbleArray[j - 1].charAt(1)) {
					String temString = bubbleArray[j];
					bubbleArray[j] = bubbleArray[j - 1];
					bubbleArray[j - 1] = temString;
				}
			}
		}

		return bubbleArray;
	}

	public static String[] selectionSort(String[] card,int n) {
		String[] selectionArrayStrings = card.clone();
		for(int i = 0;i < selectionArrayStrings.length;i++) {
			int minj = i;
			for(int j = i;j < selectionArrayStrings.length;j++) {
				if((int)selectionArrayStrings[j].charAt(1) < (int)selectionArrayStrings[minj].charAt(1)) {
					minj = j;
				}
			}

				String tempString = selectionArrayStrings[i];
				selectionArrayStrings[i] = selectionArrayStrings[minj];
				selectionArrayStrings[minj] = tempString;


		}
		return selectionArrayStrings;
	}

	/**
	 * 選択ソートが安定したソートかどうかを判定する
	 * @param bubbleArray
	 * @param selectionArray
	 * @return
	 */
	public static boolean isStable(String[] bubbleArray,String[] selectionArray) {
		for(int i = 0;i < bubbleArray.length;i++) {
			for(int j = i + 1;j < bubbleArray.length;j++) {
				for(int a = 0; a < bubbleArray.length;a++) {
					for(int b = a + 1;b < bubbleArray.length;b++) {
						if((int)bubbleArray[i].charAt(1) == (int)selectionArray[j].charAt(1) && bubbleArray[i].equals(selectionArray[b]) && bubbleArray[j].equals(selectionArray[a])) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}
}

