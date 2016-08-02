/*
 * https://www.acmicpc.net/problem/1541
 * 
 */
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int result = 0;

		// 처음 (-) 부호를 만날 때까지는 숫자를 더해주고 (-) 부호를 만나면 숫자를 빼줌 
		int s = (str.indexOf("-") == -1) ? str.length() : str.indexOf("-");

		String[] str1 = str.substring(0, s).split("\\+|\\-");
		for (int i = 0; i < str1.length; i++)
			result += Integer.parseInt(str1[i]);

		if (str.indexOf("-") != -1) {
			String[] str2 = str.substring(s + 1).trim().split("\\+|\\-");
			for (int i = 0; i < str2.length; i++)
				result -= Integer.parseInt(str2[i]);
		}

		System.out.println(result);
	}
}
