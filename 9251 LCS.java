/*
 * https://www.acmicpc.net/problem/9251
 * 동적계획법, 최장 공통 부분 문자열(불연속, Longest Common Subsequence)
 */
import java.util.*;

public class Main {
	// 첫 번째 문자열 인덱스 i와 두 번째 문자열 인덱스 j까지의 Longest Common Subsequence의 길이를 저장하는 배열
	static int[][] cache = new int[1001][1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		char[] ch1 = new char[str1.length()];
		for (int i = 0; i < str1.length(); i++)
			ch1[i] = str1.charAt(i);

		String str2 = sc.nextLine();
		char[] ch2 = new char[str2.length()];
		for (int i = 0; i < str2.length(); i++)
			ch2[i] = str2.charAt(i);

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (ch1[i - 1] == ch2[j - 1])
					cache[i][j] = cache[i - 1][j - 1] + 1;
				else
					cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
			}
		}

		/*
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				System.out.print(cache[i][j] + " ");
			}
			System.out.println();
		}
		*/

		System.out.println(cache[ch1.length][ch2.length]);
	}
}
