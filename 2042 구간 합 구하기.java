/*
 * https://www.acmicpc.net/problem/2042
 * 팬윅트리, 팬윅트리 갱신, 구간 합
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n;

	static class FenwickTree {
		ArrayList<Long> list = new ArrayList<Long>();

		// 팬윅트리 초기화
		FenwickTree() {
			for (int i = 0; i <= n; i++)
				list.add((long) 0);
		}

		// 팬윅트리 구간합
		public long sum(int pos) {
			long result = 0;
			while (pos > 0) {
				result += list.get(pos);
				pos -= (pos & -pos);
			}
			return result;
		}

		// 팬윅트리 갱신
		public void update(int pos, long diff) {
			while (pos < list.size()) {
				list.set(pos, list.get(pos) + diff);
				pos += (pos & -pos);
			}
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp[] = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int k = Integer.parseInt(temp[2]);

		// 입력 데이터를 받을 배열
		long[] data = new long[n + 1];

		// 입력 데이터를 팬윅트리로 만들어 줄 객체 
		FenwickTree tree = new FenwickTree();
		
		for (int i = 1; i <= n; i++) {
			data[i] = Long.parseLong(br.readLine());
			tree.update(i, data[i]);
		}

		for (int i = 1; i <= m + k; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int mode = Integer.parseInt(st.nextToken());

			// a index에 존재하는 값을 b로 바꾼다는 말은 a index에 b - list.get(a)를 더해준다는 말과 같음
			if (mode == 1) {
				int a = Integer.parseInt(st.nextToken());
				long b = Long.parseLong(st.nextToken());
				
				// 팬윅트리를 갱신할 때 더해줄 값을 구함
				long diff = b - data[a];
				tree.update(a, diff);
				
				// 입력 데이터 배열을 수정해준다. 그래야만 향후 diff를 제대로 계산할 수 있음
				data[a] = b;
			}

			// 구간 합 구하기
			else if (mode == 2) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				bw.write((tree.sum(b) - tree.sum(a - 1)) + "\n");
			}
		}

		bw.flush();
	}
}
