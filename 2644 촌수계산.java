import java.util.*;

public class Main {
	static int[][] adj = new int[101][101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		final int INF = 987654321;

		for (int i = 0; i < adj.length; i++)
			for (int j = 0; j < adj.length; j++)
				if (i != j)
					adj[i][j] = INF;

		int m = sc.nextInt();
		
		// 무방향그래프로 인접행렬을 채워줌
		for (int i = 1; i <= m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj[y][x] = adj[x][y] = 1;
		}
    
                // 플로이드 알고리즘을 이용해 최단거리를 갱신
		for (int k = 1; k < adj.length; k++)
			for (int i = 1; i < adj.length; i++)
				for (int j = 1; j < adj.length; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                
                // 연결된 곳이라면 거리를 출력하고 그렇지 않다면 -1을 출력
		if (adj[num1][num2] < INF)
			System.out.println(adj[num1][num2]);
		else
			System.out.println(-1);
		
	}
}
