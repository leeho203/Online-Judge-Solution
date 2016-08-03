/*
 * https://www.acmicpc.net/problem/2262
 * 메모이제이션
 */
import java.util.*;
import java.io.*;

public class Main {
	static long[][][] cache = new long[101][101][101];
	static final int MOD = 1000000007;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			cache[i][1][i] = 1;
			cache[i][i][1] = 1;
		}

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= l; j++)
				for (int k = 1; k <= r; k++)
					if (cache[i][j][k] == 0)
						cache[i][j][k] = (cache[i - 1][j - 1][k]%MOD + cache[i - 1][j][k - 1]%MOD+ ((i - 2) * cache[i - 1][j][k])%MOD)%MOD;

		System.out.println(cache[n][l][r]);
	}
}
