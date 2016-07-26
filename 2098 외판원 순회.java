/*
 * https://www.acmicpc.net/problem/2098
 * 완전탐색, 메모이제이션
 */
import java.util.*;
import java.io.*;

public class Main {
	static int V;
	static int[][] adj;
	static int[][] cache;
	static int end;

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		adj = new int[V + 1][V + 1];
		cache = new int[V + 1][1 << (V + 1)];

		for (int i = 1; i <= V; i++)
			for (int j = 1; j <= V; j++) {
				adj[i][j] = sc.nextInt();
				if (adj[i][j] == 0)
					adj[i][j] = 987654321;
			}

		for (int i = 0; i < cache.length; i++)
			for (int j = 0; j < cache[i].length; j++)
				cache[i][j] = -1;

		// 어디를 시작점으로 하든 사이클을 구하는 것이므로 한 번만 돌면 답을 구할 수 있음
		end = 1;
		System.out.println(shortestPath(1, 1));
	}

	static int shortestPath(int here, int visited) {
		int result = 987654321;

		// 모든 도시를 다 방문했다면 첫 번째 도시로 돌아가고 종료
		if (visited == ((1 << V) - 1))
			return adj[here][end];

		if (cache[here][visited] != -1)
			return cache[here][visited];

		for (int next = 1; next <= V; next++) {
			// 해당 도시를 이미 방문했다면 더이상 방문하지 않음
			if ((visited & (1 << (next - 1))) >= 1)
				continue;
			result = Math.min(result, adj[here][next] + shortestPath(next, visited + (1 << (next - 1))));
		}

		return cache[here][visited] = result;
	}
}
