/*
 * https://www.acmicpc.net/problem/11049
 * 동적계획법, 분할정복
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static Matrix[] matrix;
	// 메모이제이션을 하기 위한 배열
	static int[][] cache;

	static class Matrix {
		private int y;
		private int x;

		Matrix(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		matrix = new Matrix[n + 1];
		cache = new int[n + 1][n + 1];

		for (int i = 0; i < cache.length; i++)
			for (int j = 0; j < cache[i].length; j++)
				cache[i][j] = -1;

		for (int i = 1; i <= n; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			matrix[i] = new Matrix(y, x);
		}

		System.out.println(solution(1, n));
	}
        
        // 입력된 행렬에 번호를 매겨서 p번 행렬에서 q번 행렬까지의 곱셈 연산 횟수의 최소값을 구하는 메서드
	static int solution(int p, int q) {
		int result = Integer.MAX_VALUE;
		
		// basecase : 행렬이 한 개 주어지면 곱셈 연산의 수는 0
		if (p == q)
			return 0;
		// basecase : 행렬이 두 개 주어지면 곱셈 연산의 수는 matrix[p].y * matrix[p].x * matrix[q].x
		if (p + 1 == q)
			return matrix[p].y * matrix[p].x * matrix[q].x;
		
		if (cache[p][q] != -1)
			return cache[p][q];

                // 행렬이 세 개 이상 주어지면 두 부분으로 나누고 그 결과들을 다시 합치는 과정이 필요함
		for (int i = p; i < q; i++)
			result = Math.min(result, matrix[p].y * matrix[i].x * matrix[q].x + solution(p, i) + solution(i + 1, q));

		return cache[p][q] = result;
	}
}
