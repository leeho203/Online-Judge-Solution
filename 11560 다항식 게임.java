/*
 * https://www.acmicpc.net/problem/11560
 * 동적계획법
 */
import java.util.*;

public class Main {
	static long[][] cache = new long[21][211];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";

		for (int i = 1; i < cache.length; i++)
			cache[i][0] = 1;

		cache[1][1] = 1;

		for (int k = 2; k < cache.length; k++) {
			int len = k * (k + 1) / 2;
			for (int n = 1; n <= len; n++) {
				cache[k][n] = cache[k][n - 1] + cache[k - 1][n];
				if (n - k - 1 >= 0)
					cache[k][n] -= cache[k - 1][n - k - 1];
			}
		}

		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			result += cache[k][n] + "\n";
		}

		System.out.print(result);
	}
}
