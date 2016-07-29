/*
 * https://www.acmicpc.net/problem/1197
 * 유니온 파인드, 크루스칼 알고리즘
 */
import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	static int[] rank;

	static class Edge {
		int here;
		int there;
		int weight;

		Edge(int here, int there, int weight) {
			this.here = here;
			this.there = there;
			this.weight = weight;
		}
	}

	// vertex의 루트 vertex를 찾기 위한 메서드
	static int find(int vertex) {
		if (parent[vertex] == vertex) {
			return vertex;
		} else {
			parent[vertex] = find(parent[vertex]);
			return parent[vertex];
		}
	}

	// v1과 v2의 루트 vertex를 찾고 같은 루트 vertex를 같지 않다면 높이가 낮은 트리를 높이가 높은 트리로 합쳐줌
	// 각 트리의 높이가 같다면 p2를 p1으로 합쳐주고 p1의 높이를 하나 늘려줌
	static void merge(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);

		if (p1 == p2)
			return;

		if (rank[p1] >= rank[p2]) {
			parent[p2] = p1;
			if(rank[p1] == rank[p2])
				rank[p1]++;
		} else
			parent[p1] = p2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int V = Integer.parseInt(temp[0]);
		int E = Integer.parseInt(temp[1]);

		Edge[] edge = new Edge[E];
		parent = new int[V + 1];
		rank = new int[V + 1];
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;
		for (int i = 0; i < rank.length; i++)
			rank[i] = 1;

		for (int i = 0; i < E; i++) {
			String[] str = br.readLine().split(" ");
			int u = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
			int w = Integer.parseInt(str[2]);
			edge[i] = new Edge(u, v, w);
		}

		// 최소 스패닝 트리를 만들기 위해 weight를 오름차순으로 정렬
		Arrays.sort(edge, new Comparator<Edge>() {
			@Override
			public int compare(Edge v1, Edge v2) {
				return v1.weight - v2.weight;
			}
		});

		int result = 0;

		for (int i = 0; i < E; i++) {
			int here = edge[i].here;
			int there = edge[i].there;
			int weight = edge[i].weight;

			// 간선의 출발점과 도착점의 루트를 찾아줌
			// 해당 간선이 스패닝 트리에 속해있는지에 대한 여부를 확인하기 위함
			int p1 = find(here);
			int p2 = find(there);

			// 스패닝 트리에 속해있다면 continue
			if (p1 == p2)
				continue;
			// 스패닝 트리에 속해있지 않다면 스패닝 트리에 해당 간선을 추가해주고 각 부분트리를 합쳐준다
			else {
				result += weight;
				merge(p1, p2);
			}
		}

		System.out.println(result);
	}
}
