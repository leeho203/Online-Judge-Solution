import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.println(diffBtwStr(str1, str2));
	}

	// str1과 str2을 비교해서 차이가 가장 적은 숫자를 minDiff로 리턴
	static int diffBtwStr(String str1, String str2) {
		int minDiff = Integer.MAX_VALUE;
		int cnt = 0;
		int j = 0;
		for (int k = 0; k <= str2.length() - str1.length(); k++) {
			cnt = 0;
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i + j))
					cnt++;
			}
			j++;
			minDiff = Math.min(minDiff, cnt);
		}
		return minDiff;
	}
}
