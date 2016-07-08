import java.util.*;

public class Main {
	static long[] A = new long[101];
	static long[] B = new long[101];
	static long[] C = new long[101];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		int t = sc.nextInt();
		for (int i = 0; i < t; i++)
			result += tilingA(sc.nextInt()) + "\n";
		System.out.println(result);
	}

	// 꽉찬 것에 대한 경우의 수
	static int tilingA(int n) {
		int result = 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 5;
		result = tilingA(n - 1) + tilingA(n - 2) + tilingB(n - 1) + 2 * tilingC(n - 1);
		return result;
	}

	// 중간 2개 빈 것에 대한 경우의 수
	static int tilingB(int n) {
		int result = 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		result = tilingB(n - 2) + tilingA(n - 1);
		return result;
	}

	// 하단 2개 빈 것에 대한 경우의 수
	static int tilingC(int n) {
		int result = 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		result = tilingC(n - 1) + tilingA(n - 1);
		return result;
	}
}
