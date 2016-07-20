/*
 * https://www.acmicpc.net/problem/2240
 * 완전탐색, 동적계획법
 */

import java.util.*;

public class Main {
	static int[] time;
	static int[][][] cache = new int[3][1001][31];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 1 ~ 1000
		int move = sc.nextInt(); // 1 ~ 30
		time = new int[t + 1];

		for (int i = 1; i < time.length; i++)
			time[i] = sc.nextInt();

		for (int i = 0; i < cache.length; i++)
			for (int j = 0; j < cache[i].length; j++)
				for (int k = 0; k < cache[i][j].length; k++)
					cache[i][j][k] = -1;

		// 시작위치가 1인 경우와 시작위치가 2인 경우 중에 큰 값을 출력
		System.out.println(Math.max(solution(1, 1, move), solution(2, 1, move)));
	}

	// 현재위치가 currentNum이고 시간이 timeIndex이며 이동횟수가 move번 남았을 때 받을 수 있는 자두의 최대 갯수
	static int solution(int currentNum, int timeIndex, int move) {
		int result = 0;

		// Basecase 조건
		if (timeIndex == time.length || move < 0)
			return result;

		if (cache[currentNum][timeIndex][move] != -1)
			return cache[currentNum][timeIndex][move];

		// 현재 위치와 떨어지는 나무의 번호가 일치하는 경우
		if (currentNum == time[timeIndex]) {
			// 계속 위치를 고수
			result = Math.max(result, 1 + solution(currentNum, timeIndex + 1, move));
			// 위치를 바꿈
			result = Math.max(result, 1 + solution(3 - currentNum, timeIndex + 1, move - 1));
		}

		// 현재 위치와 떨어지는 나무의 번호가 일치하지 않는 경우
		if (currentNum != time[timeIndex]) {
			// 계속 위치를 고수
			result = Math.max(result, solution(currentNum, timeIndex + 1, move));
			// 위치를 바꿈
			result = Math.max(result, solution(3 - currentNum, timeIndex + 1, move - 1));
		}

		return cache[currentNum][timeIndex][move] = result;
	}
}
