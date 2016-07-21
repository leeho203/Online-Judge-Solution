/*
 * https://www.acmicpc.net/problem/5582
 * 동적계획법, 최장 공통 부분열(Longest Common Substring)
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] cache = new int[len1 + 1][len2 + 1];

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					cache[i][j] = cache[i - 1][j - 1] + 1;
				else
					cache[i][j] = 0;
			}
		}

		int max = 0;
		for (int i = 1; i <= len1; i++)
			for (int j = 1; j <= len2; j++)
				max = Math.max(max, cache[i][j]);

		System.out.println(max);
	}
}
