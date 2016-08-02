/*
 * https://www.acmicpc.net/problem/2887
 * 최적화된 유니온 파인드 자료구조, 크루스칼 알고리즘
 */
import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	static int[] rank;

	// return find(parent[v]) 대신에
	// return parent[v] = find(parent[v]) 를 써서 v의 root를 바로 알 수 있도록 함
	// 이렇게 함으로써 root를 찾아가는 시간을 단축할 수 있음
	static int find(int v) {
		if (parent[v] == v)
			return v;
		return parent[v] = find(parent[v]);
	}

	static void merge(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);

		if (p1 == p2)
			return;

		if (rank[p1] >= rank[p2]) {
			parent[p2] = p1;
			if (p1 == p2)
				rank[p1]++;
		} else
			parent[p1] = p2;
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

	static class Point {
		int point;
		int location;

		Point(int point, int location) {
			this.point = point;
			this.location = location;
		}
	}

	static class PointComparator implements Comparator<Point> {
		@Override
		public int compare(Point p1, Point p2) {
			return p1.point - p2.point;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Edge> edge = new ArrayList<Edge>();
		Point[] x = new Point[n];
		Point[] y = new Point[n];
		Point[] z = new Point[n];

		for (int i = 0; i < n; i++) {
			String[] data = br.readLine().split(" ");
			int xPoint = Integer.parseInt(data[0]);
			int yPoint = Integer.parseInt(data[1]);
			int zPoint = Integer.parseInt(data[2]);
			x[i] = new Point(xPoint, i + 1);
			y[i] = new Point(yPoint, i + 1);
			z[i] = new Point(zPoint, i + 1);
		}

		PointComparator comp = new PointComparator();
		Arrays.sort(x, comp);
		Arrays.sort(y, comp);
		Arrays.sort(z, comp);

		// edge를 직접 만들어 줌
		for (int i = 0; i < n - 1; i++) {
			edge.add(new Edge(x[i].location, x[i + 1].location, Math.abs(x[i].point - x[i + 1].point)));
			edge.add(new Edge(y[i].location, y[i + 1].location, Math.abs(y[i].point - y[i + 1].point)));
			edge.add(new Edge(z[i].location, z[i + 1].location, Math.abs(z[i].point - z[i + 1].point)));
		}

		// edge를 cost로 오름차순 정렬
		Collections.sort(edge, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.cost - e2.cost;
			}
		});

		parent = new int[n + 1];
		rank = new int[n + 1];
		int result = 0;

		for (int i = 0; i <= n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		// 최소 스패닝 트리를 구하기 위해 크루스칼 알고리즘 사용
		for (int i = 0; i < edge.size(); i++) {
			int here = edge.get(i).here;
			int there = edge.get(i).there;
			int cost = edge.get(i).cost;

			int p1 = find(here);
			int p2 = find(there);

			if (p1 == p2)
				continue;
			else {
				result += cost;
				merge(here, there);
			}
		}

		System.out.println(result);
	}
}
