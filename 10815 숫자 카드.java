/*
 * https://www.acmicpc.net/problem/10815
 * 이진 검색 트리
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		TreeSet<Integer> tree = new TreeSet<Integer>();

		String dataStr = br.readLine();
		StringTokenizer st = new StringTokenizer(dataStr, " ");
		while (st.hasMoreTokens()) {
			tree.add(Integer.parseInt(st.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		String searchStr = br.readLine();
		st = new StringTokenizer(searchStr, " ");
		while (st.hasMoreTokens()) {
			boolean isContained = tree.contains(Integer.parseInt(st.nextToken()));
			if (isContained)
				bw.write("1 ");
			else
				bw.write("0 ");
		}

		bw.flush();

	}
}
