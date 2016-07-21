/*
 * https://www.acmicpc.net/problem/9184
 * 동적계획법
 */
import java.util.*;

public class Main {
	static int[][][] dp = new int[21][21][21];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";

		for (int i = 0; i < dp.length; i++)
			for (int j = 0; j < dp[i].length; j++)
				for (int k = 0; k < dp[i][j].length; k++)
					dp[i][j][k] = -1;

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == -1 && b == -1 && c == -1)
				break;

			result += "w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n";
		}

		System.out.println(result);
	}
        
        // 함수적 투명성을 띄면서 중복된 부분문제를 가지고 있으므로 메모이제이션을 이용하여 속도 개선
	static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		if (a > 20 || b > 20 || c > 20)
			return w(20, 20, 20);
		if (dp[a][b][c] != -1)
			return dp[a][b][c];
		if (a < b && b < c)
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
}
