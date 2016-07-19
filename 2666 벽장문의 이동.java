/*
 * https://www.acmicpc.net/problem/2666 
 * 완전탐색, 동적계획법
 */
import java.util.*;

public class Main {
	static int n;
	// 열린 문의 위치를 저장
	static int open1;
	static int open2;
	// 정렬 대상 인덱스를 저장하는 배열
	static int[] order;
	// 메모이제이션 배열
	static int[][][] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		open1 = sc.nextInt();
		open2 = sc.nextInt();

		int m = sc.nextInt();
		order = new int[m + 1];
		for (int i = 1; i <= m; i++)
			order[i] = sc.nextInt();

		cache = new int[n + 1][n + 1][m + 1];
		for (int i = 0; i < cache.length; i++)
			for (int j = 0; j < cache[i].length; j++)
				for (int k = 0; k < cache[i][j].length; k++)
					cache[i][j][k] = -1;

		System.out.println(closet(open1, open2, 1));
	}

	// open1, open2가 열린 문일 때 orderIndex를 늘려가면서 최소 이동 횟수를 구하는 메서드
	static int closet(int open1, int open2, int orderIndex) {
		int result = 987654321;

		if (orderIndex == order.length)
			return 0;
		
		if (cache[open1][open2][orderIndex] != -1)
			return cache[open1][open2][orderIndex];

		result = Math.min(result,
				Math.abs(open1 - order[orderIndex]) + closet(order[orderIndex], open2, orderIndex + 1));
		result = Math.min(result,
				Math.abs(open2 - order[orderIndex]) + closet(open1, order[orderIndex], orderIndex + 1));
		
		return cache[open1][open2][orderIndex] = result;
	}
}
