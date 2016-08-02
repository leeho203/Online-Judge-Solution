/*
 * https://www.acmicpc.net/problem/2004
 * 팩토리얼 0의 개수, 조합 0의 개수
 */
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		long two = solution(n, 0) - solution(n - m, 0) - solution(m, 0);
		long five = solution(n, 1) - solution(n - m, 1) - solution(m, 1);

		System.out.println(Math.min(two, five));
	}

	static long solution(int num, int mode) {
		long result = 0;
		int start = (mode == 0) ? 2 : 5;

		for (long i = start; i <= num; i *= start)
			result += num / i;

		return result;
	}
}
