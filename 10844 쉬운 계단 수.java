/*
 * https://www.acmicpc.net/problem/10844
 * 동적계획법
 */
import java.util.*;

public class Main {
	static int[][] cache = new int[101][10];
	static final int MOD = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int j = 0; j <= 9; j++)
			cache[1][j] = 1;

		for (int i = 2; i <= 100; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j > 0)
					cache[i][j] = (cache[i][j] % MOD + cache[i - 1][j - 1] % MOD) % MOD;
				if (j < 9)
					cache[i][j] = (cache[i][j] % MOD + cache[i - 1][j + 1] % MOD) % MOD;
			}
		}

		int result = 0;
		for (int i = 1; i <= 9; i++)
			result = (result % MOD + cache[n][i] % MOD) % MOD;
		System.out.println(result);

	}
}
