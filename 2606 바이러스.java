import java.util.*;

public class Main {
	static int[][] adj;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		adj = new int[n + 1][n + 1];
		int cnt = 0;

		// 같은 정점의 거리는 0, 다른 정점의 거리는 무한대(임의의 매우 큰 값)로 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					adj[i][j] = 0;
				else
					adj[i][j] = 987654321;
			}
		}

		int m = sc.nextInt();

		// 무방향그래프이므로 연결이 되어 있다면 adj[v1][v2] = adj[v2][v1] = 1로 바꿔줌
		for (int i = 1; i <= m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adj[v1][v2] = 1;
			adj[v2][v1] = 1;
		}

		// 플로이드 알고리즘을 이용해 최단경로를 계산해서 인접행렬에 갱신해줌
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);

		// 1과 연결되어 있는 정점의 갯수를 셈
		for (int i = 2; i <= n; i++)
			if (adj[1][i] < 987654321)
				cnt++;

		System.out.println(cnt);

	}
}
