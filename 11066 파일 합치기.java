/*
 * https://www.acmicpc.net/problem/11066
 * 분할정복, 메모이제이션, 구간합
 */
import java.util.*;
import java.io.*;

public class Main {
	static int[] data = new int[501];
	static int[] sum = new int[501];
	static int[][] cache = new int[501][501];

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		String result = "";
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			
			for (int j = 0; j < data.length; j++)
				data[j] = 0;

			for (int j = 0; j < sum.length; j++)
				sum[j] = 0;

			for (int j = 0; j < cache.length; j++)
				for (int k = 0; k < cache[j].length; k++)
					cache[j][k] = -1;

			for (int j = 1; j <= n; j++)
				data[j] = sc.nextInt();

			for (int j = 1; j <= n; j++)
				sum[j] = sum[j - 1] + data[j];

			result += mergingFile(1, n) + "\n";
		}

		System.out.print(result);
	}

	// 점화식 : dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[j] - sum[i-1]) (단 i<=k<j)
	static int mergingFile(int left, int right) {
		int min = Integer.MAX_VALUE;
		if (left >= right)
			return 0;
		if (left + 1 == right)
			return data[left] + data[right];
		if (cache[left][right] != -1)
			return cache[left][right];
		for (int k = left; k < right; k++)
			min = Math.min(min, mergingFile(left, k) + mergingFile(k + 1, right) + sum[right] - sum[left - 1]);
		return cache[left][right] = min;
	}
}
