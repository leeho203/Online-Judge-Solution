/*
 * https://www.acmicpc.net/problem/1254
 * 
 */
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String reverseStr = "";

		for (int i = str.length() - 1; i >= 0; i--)
			reverseStr += str.charAt(i);

		for (int i = 0; i < str.length(); i++) {
			boolean isEqualToReverse = true;
			int k = 0;
			for (int j = i; j < str.length(); j++) {
				if (str.charAt(j) != reverseStr.charAt(k))
					isEqualToReverse = false;
				k++;
			}

			if (isEqualToReverse) {
				System.out.println(i + reverseStr.length());
				break;
			}
		}
	}
}
