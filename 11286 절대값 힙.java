/*
 * https://www.acmicpc.net/problem/11286
 * 힙
 */
import java.util.*;
import java.io.*;

public class Main {
	static class AbsComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			int result = Math.abs(o1) - Math.abs(o2);
			if (Math.abs(o1) == Math.abs(o2))
				result = o1 - o2;
			return result;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> que = new PriorityQueue<Integer>(new AbsComparator());

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0)
				if (!que.isEmpty())
					bw.write(que.remove() + "\n");
				else
					bw.write("0\n");
			else
				que.add(x);
		}

		bw.flush();
	}
}
