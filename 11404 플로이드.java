/*
 * https://www.acmicpc.net/problem/11404
 * 플로이드 알고리즘
 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		int[][] adj = new int[V + 1][V + 1];
		final int INF = 987654321;

		for (int i = 1; i <= V; i++)
			for (int j = 1; j <= V; j++) {
				if (i == j)
					adj[i][j] = 0;
				else
					adj[i][j] = INF;
			}

		for (int i = 0; i < E; i++) {
			String[] str = br.readLine().split(" ");
			int V1 = Integer.parseInt(str[0]);
			int V2 = Integer.parseInt(str[1]);
			int W = Integer.parseInt(str[2]);
			adj[V1][V2] = Math.min(adj[V1][V2], W);
		}

		for (int k = 1; k <= V; k++)
			for (int i = 1; i <= V; i++)
				for (int j = 1; j <= V; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++)
				bw.write(adj[i][j] + " ");
			bw.write("\n");
		}

		bw.flush();

	}
}
