import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(tilingA(n));
	}

	// 꽉찬 것에 대한 경우의 수
	static int tilingA(int n) {
		int result = 0;
		if (n == 0)
			return 1;
		if (n == 1)
			return 0;
		result = tilingA(n - 2) + 2 * tilingB(n - 1);
		return result;
	}

	// 하단 2개 빈 것에 대한 경우의 수
	static int tilingB(int n) {
		int result = 0;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		result = tilingB(n - 2) + tilingA(n - 1);
		return result;
	}
}
