/*
 * https://www.acmicpc.net/problem/2998
 * 
 */
import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String result = "";
		int mod = str.length() % 3;

		if (mod == 1)
			str = "00" + str;
		else if (mod == 2)
			str = "0" + str;

		for (int i = 0; i < str.length() - 2; i += 3)
			result += (Integer.parseInt(str.charAt(i) + "") * 4 + Integer.parseInt(str.charAt(i + 1) + "") * 2
					+ Integer.parseInt(str.charAt(i + 2) + ""));

		System.out.println(result);
	}
}
