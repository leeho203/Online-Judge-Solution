/*
 * https://www.acmicpc.net/problem/1670
 * 동적계획법
 */
import java.util.*;

public class Main {
	static long[] cache = new long[10001];
	static final long MOD = 987654321;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		int n = sc.nextInt();
		System.out.println(handshake(n));
	}

	static long handshake(int n) {
		long result = 0;
		if (n == 0 || n == 2)
			return 1;
		if (n == 4)
			return 2;
		if (cache[n] != -1)
			return cache[n];
		for (int i = n; i > 0; i -= 2)
			result = (result % MOD + ((handshake(n - i) % MOD * handshake(n - (n + 2 - i)) % MOD) % MOD) % MOD) % MOD;
		return cache[n] = result;
	}
}
