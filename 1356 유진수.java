/*
 * https://www.acmicpc.net/problem/1356
 * 
 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean isYujinSu = false;
		String str = sc.nextLine();

		for (int i = 1; i < str.length(); i++) {
			int num1 = 1;
			int num2 = 1;
			String str1 = str.substring(0, i);
			String str2 = str.substring(i, str.length());
			
			for (int j = 0; j < str1.length(); j++)
				num1 *= Integer.parseInt(str1.charAt(j) + "");

			for (int j = 0; j < str2.length(); j++)
				num2 *= Integer.parseInt(str2.charAt(j) + "");

			if (num1 == num2)
				isYujinSu = true;
		}

		if (isYujinSu)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
