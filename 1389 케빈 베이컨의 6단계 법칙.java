import java.util.*;
import java.io.*;

public class Main {
	static int[][] adj = new int[101][101];
	static int[] kevinBacon = new int[101];

	public static void main(String[] args) throws IOException {
		for (int i = 1; i < adj.length; i++) {
			for (int j = 1; j < adj[i].length; j++) {
				if (i == j)
					adj[i][j] = 0;
				else
					adj[i][j] = 987654321;
			}
		}

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;
		}

		for (int k = 1; k <= V; k++)
			for (int i = 1; i <= V; i++)
				for (int j = 1; j <= V; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);

		for (int i = 1; i <= V; i++)
			for (int j = 1; j <= V; j++)
				if (adj[i][j] < 987654321)
					kevinBacon[i] += adj[i][j];

		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i = 1; i <= V; i++) {
			if (kevinBacon[i] < min) {
				min = kevinBacon[i];
				minIndex = i;
			}
		}

		System.out.print(minIndex);

	}
}
