import java.util.*;

public class Main {

	static int[][] dp = new int[501][501];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int[][] arr = new int[y][x];

		// dp배열 초기화
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}

		// 배열 입력 받기
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.print(findWay(arr, 0, 0));

	}

	static int findWay(int[][] arr, int y, int x) {
		int result = 0;
		if (y > arr.length || y < 0 || x > arr[0].length || x < 0) {
			return 0;
		}

		if (y == arr.length - 1 && x == arr[0].length - 1) {
			return 1;
		}

		if (dp[y][x] != -1)
			return dp[y][x];

		if (y >= 1)
			if (arr[y][x] > arr[y - 1][x])
				result += findWay(arr, y - 1, x);
		if (x < arr[0].length - 1)
			if (arr[y][x] > arr[y][x + 1])
				result += findWay(arr, y, x + 1);
		if (y < arr.length - 1)
			if (arr[y][x] > arr[y + 1][x])
				result += findWay(arr, y + 1, x);
		if (x >= 1)
			if (arr[y][x] > arr[y][x - 1])
				result += findWay(arr, y, x - 1);

		return dp[y][x] = result;
	}
}
