import java.util.*;

public class Main {
	static long[] cache = new long[101];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		for (int i = 1; i <= t; i++)
			System.out.println(padoban(sc.nextInt()));
	}

	static long padoban(int n) {
		if (n == 1 || n == 2 || n == 3)
			return 1;
		if (cache[n] != -1)
			return cache[n];
		return cache[n] = padoban(n - 2) + padoban(n - 3);
	}
}
