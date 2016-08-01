/*
 * https://www.acmicpc.net/problem/1188
 * 비트 마스크
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long[] binary = new long[100];

		int idx = 0;
		while (n > 0) {
			binary[idx] = n % 2;
			n /= 2;
			idx++;
		}

		long ans = 0;
		for (int i = 0; i < idx; i++) {
			long temp = 1;
			for (int j = 1; j <= i; j++)
				temp *= 3;
			ans += binary[i] * temp;
		}

		System.out.println(ans);
	}
}
