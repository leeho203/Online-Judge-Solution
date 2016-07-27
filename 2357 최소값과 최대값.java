/*
 * https://www.acmicpc.net/problem/2357
 * 인덱스드 트리
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static final int MAX_INF = Integer.MAX_VALUE;
	static final int MIN_INF = Integer.MIN_VALUE;

	static class IndexedTree {
		int first;
		int mode;
		ArrayList<Integer> tree = new ArrayList<Integer>();

		// mode가 0이면 max구하기, mode가 1이면 min구하기
		IndexedTree(int m) {
			this.mode = m;

			// 원소가 들어갈 첫 번째 인덱스를 구함
			for (first = 1; first < n; first <<= 1);
			// pos가 1부터 시작하므로 first에서 1을 빼줌
			first--;

			// 4 * n으로 배열 설정
			if (mode == 0)
				for (int i = 0; i < n << 2; i++)
					tree.add(MIN_INF);
			else
				for (int i = 0; i < n << 2; i++)
					tree.add(MAX_INF);
		}

		public void update(int pos, int val) {
			pos += first;
			tree.set(pos, val);

			if (mode == 0)
				while ((pos >> 1) > 0) { // 부모 노드가 존재한다면 자식노드와 부모노드를 비교
					tree.set(pos >> 1, Math.max(tree.get(pos >> 1), tree.get(pos)));
					pos >>= 1;
				}
			else
				while ((pos >> 1) > 0) { // 부모 노드가 존재한다면 자식노드와 부모노드를 비교
					tree.set(pos >> 1, Math.min(tree.get(pos >> 1), tree.get(pos)));
					pos >>= 1;
				}
		}

		public int max(int left, int right) {
			left += first;
			right += first;
			int result = MIN_INF;
			// 트리의 깊이를 줄이면서 가장 큰 값을 찾음
			while (left <= right) {
				result = Math.max(result, Math.max(tree.get(left), tree.get(right)));
				left = (left + 1) / 2;
				right = (right - 1) / 2;
			}
			return result;
		}

		public int min(int left, int right) {
			left += first;
			right += first;
			int result = MAX_INF;
			// 트리의 깊이를 줄이면서 가장 작은 값을 찾음
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
		
		IndexedTree maxTree = new IndexedTree(0);
		IndexedTree minTree = new IndexedTree(1);

                // 데이터 입력
		for (int i = 1; i <= n; i++) {
			int data = Integer.parseInt(br.readLine());
			maxTree.update(i, data);
			minTree.update(i, data);
		}
                
                // 인덱스트 트리를 이용해서 [start, end]에 해당하는 최대값과 최소값을 빠르게 구함
		for (int i = 1; i <= m; i++) {
			String[] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			bw.write(minTree.min(start, end) + " ");
			bw.write(maxTree.max(start, end) + "\n");
		}
		
		bw.flush();
	}
}
