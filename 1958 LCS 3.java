import java.util.*;

public class Main {
	// 첫 번째 문자열 인덱스 i, 두 번째 문자열 인덱스 j, 세 번째 문자열 인덱스 k까지의 Longest Common Subsequence의 길이를 저장하는 배열
	static int[][][] cache = new int[101][101][101];

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

		String str3 = sc.nextLine();
		char[] ch3 = new char[str3.length()];
		for (int i = 0; i < str3.length(); i++)
			ch3[i] = str3.charAt(i);

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				for (int k = 1; k <= str3.length(); k++) {
					if (ch1[i - 1] == ch2[j - 1] && ch2[j - 1] == ch3[k - 1])
						cache[i][j][k] = cache[i - 1][j - 1][k - 1] + 1;
					else
						cache[i][j][k] = Math.max(Math.max(cache[i - 1][j][k], cache[i][j - 1][k]), cache[i][j][k - 1]);
				}
			}
		}

		System.out.println(cache[ch1.length][ch2.length][ch3.length]);
	}
}
