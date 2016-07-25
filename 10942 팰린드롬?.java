/*
 * https://www.acmicpc.net/problem/10942
 * 재귀호출
 */
import java.util.*;
import java.io.*;

public class Main {
	static int[] data;
	static int[][] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		data = new int[n + 1];
		cache = new int[n + 1][n + 1];

		String temp = br.readLine();
		StringTokenizer st = new StringTokenizer(temp, " ");
		for (int i = 1; i <= n; i++)
			data[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < cache.length; i++)
			for (int j = 0; j < cache[i].length; j++)
				cache[i][j] = -1;

		int m = Integer.parseInt(br.readLine());
		
		String result = "";
		int start, end;
		
		for (int i = 1; i <= m; i++) {
			String[] str = br.readLine().split(" ");
			start = Integer.parseInt(str[0]);
			end = Integer.parseInt(str[1]);
			bw.write(isPalindrome(start, end) + "\n");
		}

		bw.flush();

	}

	static int isPalindrome(int start, int end) {
		int result = 0;
		if (start >= end)
			return 1;
		if (cache[start][end] != -1)
			return cache[start][end];
		if (data[start] == data[end])
			result = isPalindrome(start + 1, end - 1);
		return cache[start][end] = result;
	}
}
