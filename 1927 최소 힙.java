/*
 * https://www.acmicpc.net/problem/1927
 * 힙
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> que = new PriorityQueue<Integer>();

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
