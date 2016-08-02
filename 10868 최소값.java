/*
 * https://www.acmicpc.net/problem/10868
 * 인덱스드 트리
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static final int MAX_INF = Integer.MAX_VALUE;

	static class IndexedTree {
		int first;
		int mode;
		ArrayList<Integer> tree = new ArrayList<Integer>();

		IndexedTree() {
			// 원소가 들어갈 첫 번째 인덱스를 구함
			for (first = 1; first < n; first <<= 1)
				;
			first--;

			// 4 * n으로 배열 설정
			for (int i = 0; i < n << 2; i++)
				tree.add(MAX_INF);
		}

		public void update(int pos, int val) {
			pos += first;
			tree.set(pos, val);

			while ((pos >> 1) > 0) {
				tree.set(pos >> 1, Math.min(tree.get(pos >> 1), tree.get(pos)));
				pos >>= 1;
			}
		}

		public int min(int left, int right) {
			left += first;
			right += first;
			int result = MAX_INF;
			while (left <= right) {
				result = Math.min(result, Math.min(tree.get(left), tree.get(right)));
				left = (left + 1) / 2;
				right = (right - 1) / 2;
			}
			return result;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		IndexedTree minTree = new IndexedTree();

		for (int i = 1; i <= n; i++) {
			int data = Integer.parseInt(br.readLine());
			minTree.update(i, data);
		}

		for (int i = 1; i <= m; i++) {
			String[] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			bw.write(minTree.min(start, end) + "\n");
		}

		bw.flush();
	}
}
