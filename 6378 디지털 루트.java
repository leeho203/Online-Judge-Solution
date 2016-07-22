/*
 * https://www.acmicpc.net/problem/6378
 * 재귀호출
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		while (true) {
			String str = sc.nextLine();
			if (str.charAt(0) == '0' && str.length() == 1)
				break;
			result += digitalRoute(str) + "\n";
		}

		System.out.print(result);
	}

	static String digitalRoute(String str) {
		int result = 0;
		int len = str.length();

		if (len == 1)
			return str;

		for (int i = 0; i < len; i++)
			result += Integer.parseInt(str.charAt(i) + "");

		return digitalRoute(result + "");
	}
}
