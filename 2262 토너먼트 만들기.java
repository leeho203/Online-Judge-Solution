/*
 * https://www.acmicpc.net/problem/2262
 * 분할정복, 메모이제이션, 구간의 최소값
 */
import java.util.*;
import java.io.*;

public class Main {
	// 데이터 입력 받을 배열
	static int[] data = new int[257];
	// i부터 j까지의 구간에서, 랭크의 최소값을 저장하는 배열
	static int[][] minRank = new int[257][257];
	// i부터 j까지의 구간에서, 랭킹 차이 총 합의 최소값을 저장하는 배열
	static int[][] cache = new int[257][257];

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < cache.length; i++)
			for (int j = 0; j < cache[i].length; j++)
				cache[i][j] = -1;

		for (int i = 1; i <= n; i++)
			data[i] = sc.nextInt();

		for (int i = 0; i < minRank.length; i++)
			for (int j = 0; j < minRank[i].length; j++)
				if (i == j)
					minRank[i][j] = data[i];

		for (int i = 1; i < n; i++)
			for (int j = 1; j <= n - i; j++)
				minRank[j][j + i] = Math.min(minRank[j][j + i - 1], minRank[j + 1][j + i]);

		System.out.println(betweenRank(1, n));
	}

	static int betweenRank(int left, int right) {
		int result = Integer.MAX_VALUE;

		if (left >= right)
			return 0;

		if (cache[left][right] != -1)
			return cache[left][right];

		for (int k = left; k < right; k++)
			result = Math.min(result, betweenRank(left, k) + betweenRank(k + 1, right)
					+ Math.abs(minRank[left][k] - minRank[k + 1][right]));

		return cache[left][right] = result;
	}
}
