/*
 * https://www.acmicpc.net/problem/11057
 * 동적계획법
 */

import java.util.*;

public class Main {
	static long[][] cache = new long[11][1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i < cache.length; i++)
			cache[i][1] = 1;

		for (int j = 1; j < cache[0].length; j++)
			cache[1][j] = 1;

		for (int i = 2; i < cache.length; i++)
			for (int j = 2; j < cache[i].length; j++)
				cache[i][j] = ((cache[i - 1][j] % 10007) + (cache[i][j - 1] % 10007)) % 10007;

		int num = sc.nextInt();
		long result = 0;
		for (int j = 1; j < cache.length; j++)
			result = ((result % 10007) + (cache[j][num] % 10007)) % 10007;

		System.out.print(result);
	}
}
