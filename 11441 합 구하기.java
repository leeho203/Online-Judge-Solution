/*
 * https://www.acmicpc.net/problem/11441
 * 동적계획법
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		int[] dp = new int[n + 1];
		int[] data = new int[n + 1];
		int i = 1;

		while (st.hasMoreTokens()) {
			data[i] = Integer.parseInt(st.nextToken());
			if (i == 1)
				dp[i] = data[i];
			else if (i > 1)
				dp[i] = dp[i - 1] + data[i];
			i++;
		}

		int m = Integer.parseInt(br.readLine());
		for (i = 1; i <= m; i++) {
			String temp[] = br.readLine().split(" ");
			int startNum = Integer.parseInt(temp[0]);
			int endNum = Integer.parseInt(temp[1]);
			bw.write(dp[endNum] - dp[startNum - 1] + "\n");
		}

		bw.flush();

	}
}
