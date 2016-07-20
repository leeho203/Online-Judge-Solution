/*
 * https://www.acmicpc.net/problem/1495
 * 완전탐색, 동적계획법
 */

import java.util.*;

public class Main {
	static int[][] cache = new int[1001][101];
	static int minVol = 0;
	static int maxVol;
	static int[] diff;
	static int diffIndex;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int startVol = sc.nextInt();
		maxVol = sc.nextInt();
		diff = new int[n + 1];

		for (int i = 0; i < cache.length; i++)
			for (int j = 0; j < cache[i].length; j++)
				cache[i][j] = -2;

		for (int i = 1; i <= n; i++)
			diff[i] = sc.nextInt();

		System.out.println(solution(startVol, 1));

	}
	
	// currentVol을 기준으로 diffIndex번째 곡부터 마지막 곡까지 연주 한 후 마지막 곡 볼륨의 최대값을 구하는 메서드
	static int solution(int currentVol, int diffIndex) {
		int max = -1;
		// Basecase 조건 : 완주할 수 없다면 -1을 리턴
		if (currentVol > maxVol || currentVol < minVol)
			return max;
		// 마지막 곡을 완주한 후라면 그 때의 볼륨 값을 리턴
		if (diffIndex == diff.length)
			return currentVol;
		
		if (cache[currentVol][diffIndex] != -2)
			return cache[currentVol][diffIndex];

		max = Math.max(max, solution(currentVol + diff[diffIndex], diffIndex + 1));
		max = Math.max(max, solution(currentVol - diff[diffIndex], diffIndex + 1));

		return cache[currentVol][diffIndex] = max;
	}
}
