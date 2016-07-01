import java.util.*;

public class Main {

	// 인접 행렬 선언
	static boolean[][] adj = new boolean[1001][1001];

	// DFS에서 이용할 visited 배열
	static boolean[] visited = new boolean[1001];

	// BFS에서 이용할 discovered 배열
	static boolean[] discovered = new boolean[1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int here = sc.nextInt();

		// 인접 행렬 만들기
		for (int i = 1; i <= e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adj[v1][v2] = true;
			adj[v2][v1] = true;
		}

		DFS(here);
		System.out.print("\n");
		BFS(here);

	}

	static void DFS(int here) {
	  // 해당 부분을 방문했다고 판단
		System.out.print(here + " ");
		visited[here] = true;
		
	  // 인접행렬에서 here을 기준으로 모든 정점에 대해 도달할 수 있으며 아직 방문하지 않은 정점이라면 해당 정점을 방문함
		for (int there = 1; there < adj.length; there++) {
			if (adj[here][there] && !visited[there]) {
				DFS(there);
			}
		}
	}

	static void BFS(int start) {
		ArrayList<Integer> order = new ArrayList<Integer>();
	  
	  // 해당 부분을 발견했다고 설정해줌
		discovered[start] = true;
		
		// 발견한 부분에 대해서는 큐로 들어온 순서대로 처리할 것임
		ArrayList<Integer> que = new ArrayList<Integer>();
		que.add(start);

		while (!que.isEmpty()) {
		
		  // 발견한 부분을 출력해줌 -> 출력한 부분은 실제 방문한 것임
			int here = que.get(0);
			System.out.print(here + " ");
			
			// 방문했으니 큐에서 제거
			que.remove(0);
			
			// 인접행렬에서 here을 기준으로 모든 정점에 대해 도달할 수 있으며 아직 발견하지 않은 정점이라면 해당 정점을 발견했다고 판단
			for (int there = 1; there < adj.length; there++) {
				if (adj[here][there] && !discovered[there]) {
					que.add(there);
					discovered[there] = true;
				}
			}
		}
	}
}
