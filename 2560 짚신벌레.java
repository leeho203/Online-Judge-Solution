import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int death = sc.nextInt();
		int n = sc.nextInt();
		dp = new int[n + 1];
		dp[0] = 1;

		// n일까지 태어난 모든 벌레수 = n-1일까지 태어난 모든 벌레수 + n일에 새로 태어난 벌레수
		// n일까지 태어난 모든 벌레수 = n-1일까지 태어난 모든 벌레수 + 성체가 된 벌레수 - 성체지만 노화된 벌레수
		// dp[i] = dp[i-1] + (dp[i-start] - dp[i-end])
		for (int i = 1; i < dp.length; i++) {
			if (i < start)
				dp[i] = dp[i - 1] % 1000;
			else if (i < end)
				dp[i] = (dp[i - 1] + dp[i - start]) % 1000;
			else
				dp[i] = (dp[i - 1] + dp[i - start] - dp[i - end] + 1000) % 1000;
		}

		// n일에 존재하는 벌레수 = n일까지 태어난 모든 벌레수 - 죽은 벌레수
		if (n - death >= 0)
			System.out.println((dp[n] - dp[n - death] + 1000) % 1000);
		else
			System.out.println(dp[n] % 1000);

		// (-)가 나올 때 1000을 더해주는 이유는 나머지가 (-)가 되는 것을 방지하기 위함
	}
}
