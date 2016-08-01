/*
 * https://www.acmicpc.net/problem/1717
 * 상호 배타적 집합, 유니온 파인드
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

	static void merge(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if (p1 == p2)
			return;

		if (rank[p1] >= rank[p2]) {
			parent[p2] = p1;
			if (rank[p1] == rank[p2])
				rank[p1]++;
		} else
			parent[p1] = p2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] data = br.readLine().split(" ");
		int n = Integer.parseInt(data[0]);
		int m = Integer.parseInt(data[1]);

		parent = new int[n + 1];
		rank = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		for (int i = 0; i < m; i++) {
			String[] temp = br.readLine().split(" ");
			int mode = Integer.parseInt(temp[0]);
			int v1 = Integer.parseInt(temp[1]);
			int v2 = Integer.parseInt(temp[2]);

			if (mode == 0)
				merge(v1, v2);
			else if (mode == 1)
				if (find(v1) == find(v2))
					bw.write("YES\n");
				else
					bw.write("NO\n");
		}
		
		bw.flush();
	}
}
