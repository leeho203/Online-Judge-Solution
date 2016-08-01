/*
 * https://www.acmicpc.net/problem/1922
 * 유니온 파인드, 최소 스패닝 트리
 */
import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	static int[] rank;

	static int find(int v) {
		if (parent[v] == v)
			return v;
		return find(parent[v]);
	}

	static void union(int v0, int v1) {
		int p0 = find(v0);
		int p1 = find(v1);

		if (p0 == p1)
			return;

		if (rank[p0] >= rank[p1]) {
			parent[p1] = p0;
			if (rank[p0] == rank[p1])
				rank[p0]++;
		} else
			parent[v0] = p1;
	}

	static class Edge {
		int here;
		int there;
		int cost;

		Edge(int here, int there, int cost) {
			this.here = here;
			this.there = there;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		Edge[] edge = new Edge[m];
		parent = new int[n + 1];
		rank = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		for (int i = 0; i < m; i++) {
			String[] temp = br.readLine().split(" ");
			int here = Integer.parseInt(temp[0]);
			int there = Integer.parseInt(temp[1]);
			int cost = Integer.parseInt(temp[2]);
			edge[i] = new Edge(here, there, cost);
		}

		Arrays.sort(edge, new Comparator<Edge>() {
			@Override
			public int compare(Edge e0, Edge e1) {
				return e0.cost - e1.cost;
			}
		});

		int result = 0;

		for (int i = 0; i < m; i++) {
			int here = edge[i].here;
			int there = edge[i].there;
			int cost = edge[i].cost;

			int p0 = find(here);
			int p1 = find(there);

			if (p0 == p1)
				continue;
			else {
				result += cost;
				union(p0, p1);
			}
		}

		System.out.println(result);
	}
}
