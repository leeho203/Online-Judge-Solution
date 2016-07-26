/*
 * https://www.acmicpc.net/problem/2458
 * 플로이드 알고리즘
 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adjTo = new int[V + 1][V + 1];
		int[][] adjFrom = new int[V + 1][V + 1];
		int[][] adj = new int[V + 1][V + 1];
		int result = 0;

		final int INF = 987654321;

		for (int i = 1; i <= V; i++)
			for (int j = 1; j <= V; j++) {
				if (i == j)
					adjTo[i][j] = adjFrom[i][j] = 0;
				else
					adjTo[i][j] = adjFrom[i][j] = INF;
			}

		for (int i = 0; i < E; i++) {
			int V1 = sc.nextInt();
			int V2 = sc.nextInt();
			adjTo[V1][V2] = Math.min(adjTo[V1][V2], 1);
			adjFrom[V2][V1] = Math.min(adjFrom[V2][V1], 1);
		}

		for (int k = 1; k <= V; k++)
			for (int i = 1; i <= V; i++)
				for (int j = 1; j <= V; j++) {
					adjTo[i][j] = Math.min(adjTo[i][j], adjTo[i][k] + adjTo[k][j]);
					adjFrom[i][j] = Math.min(adjFrom[i][j], adjFrom[i][k] + adjFrom[k][j]);
				}

		for (int i = 1; i <= V; i++) {
			int cnt = 0;
			for (int j = 1; j <= V; j++) {
				adj[i][j] = Math.min(adjTo[i][j], adjFrom[i][j]);
				if (adj[i][j] < INF)
					cnt++;
			}
			if (cnt == V)
				result++;
		}

		bw.write(result + "\n");
		bw.flush();
	}
}
