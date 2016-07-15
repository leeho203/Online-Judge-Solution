import java.util.*;
import java.io.*;

public class Main {
	static long[] cache;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		cache = new long[n + 1];
		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		System.out.println(asymmetric(n));
	}

	static long tiling(int n) {
		long result = 0;
		if (n == 0 || n == 1)
			return 1;
		if (n == 2)
			return 3;
		if (cache[n] != -1)
			return cache[n];

		result = tiling(n - 1) + tiling(n - 2) + tiling(n - 2);
		return cache[n] = result;
	}

	static long asymmetric(int n) {
		long result = 0;
		long asym = 0;
		if (n % 2 == 1) {
			asym = tiling(n) - tiling(n / 2);
			result = asym / 2 + tiling(n / 2);
		} else {
			asym = tiling(n) - 2 * tiling(n / 2 - 1) - tiling(n / 2);
			result = asym / 2 + 2 * tiling(n / 2 - 1) + tiling(n / 2);
		}
		return result;
	}
}
