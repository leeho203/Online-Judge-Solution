/*
 * https://www.acmicpc.net/problem/1059
 * 조합
 */
import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int[] data = new int[1001];
		for (int i = 0; i < l; i++) {
			data[sc.nextInt()]++;
		}
		int n = sc.nextInt();
		int result = 0;
		int toRightCnt = 0;
		int toLeftCnt = 0;

		if (data[n] == 1)
			result = 0;
		else {
			for (int i = n + 1; i < data.length; i++) {
				if (data[i] == 0)
					toRightCnt++;
				else
					break;
			}

			for (int i = n - 1; i >= 1; i--) {
				if (data[i] == 0)
					toLeftCnt++;
				else
					break;
			}

			result = toLeftCnt + toRightCnt;
		}
		
		System.out.println(combination(result + 1, 2) - combination(toRightCnt, 2) - combination(toLeftCnt, 2));
	}

	static int combination(int n, int r) {
		if (n == r || r == 0)
			return 1;
		if (r == 1)
			return n;
		if (n < r)
			return 0;
		return combination(n - 1, r - 1) + combination(n - 1, r);
	}
}
