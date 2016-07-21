/*
 * https://www.acmicpc.net/problem/9084
 * 동적계획법
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		int t = sc.nextInt();

		for (int p = 0; p < t; p++) {
			int n = sc.nextInt();
			int[] coin = new int[n];

			for (int i = 0; i < n; i++)
				coin[i] = sc.nextInt();

			int k = sc.nextInt();
			int[] dp = new int[k + 1];

			dp[0] = 1;

			for (int i = 0; i < n; i++)
				for (int j = coin[i]; j <= k; j++)
					dp[j] += dp[j - coin[i]];

			result += dp[k] + "\n";
		}

		System.out.print(result);
	}
}
