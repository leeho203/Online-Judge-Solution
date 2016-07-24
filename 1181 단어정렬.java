/*
 * https://www.acmicpc.net/problem/1181
 * 다중정렬
 */
import java.util.*;
import java.io.*;

public class Main {

	static class StringComparator implements Comparator<String> {
		@Override
		public int compare(String s0, String s1) {
			int result = s0.length() - s1.length();
			if (s0.length() == s1.length())
				result = s0.compareTo(s1);
			return result;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			if (!list.contains(temp))
				list.add(temp);
		}

		Collections.sort(list, new StringComparator());

		for (String str : list)
			bw.write(str + "\n");

		bw.flush();

	}
}
