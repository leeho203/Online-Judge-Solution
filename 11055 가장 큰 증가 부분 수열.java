import java.util.*;
import java.io.*;

public class Main {

	static int[] dp = new int[1001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n];

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		for (int i = 0; i < dp.length; i++)
			dp[i] = -1;

		int i = 0;
		while (st.hasMoreTokens()) {
			data[i] = Integer.parseInt(st.nextToken());
			i++;
		}

		int max = Integer.MIN_VALUE;
		for (i = 0; i < n; i++) {
			max = Math.max(max, LIS(data, i));
		}

		System.out.println(max);

	}

	static int LIS(int[] data, int index) {
		int len = data.length;
		if (index == len - 1)
			return data[index];

		if (dp[index] != -1)
			return dp[index];

		int result = 0;
		for (int j = index + 1; j < len; j++) {
			if (data[j] > data[index])
				result = Math.max(result, LIS(data, j));
		}

		return dp[index] = data[index] + result;
	}
}
