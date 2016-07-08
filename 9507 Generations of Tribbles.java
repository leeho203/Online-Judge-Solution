import java.util.*;

public class Main {
	static long[] cache = new long[101];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		int t = sc.nextInt();

		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		for (int i = 1; i <= t; i++)
			result += koong(sc.nextInt()) + "\n";

		System.out.print(result);
	}

	static long koong(int n) {
		if (n < 2)
			return 1;
		if (n == 2)
			return 2;
		if (n == 3)
			return 4;
		if (cache[n] != -1)
			return cache[n];
		return cache[n] = koong(n - 1) + koong(n - 2) + koong(n - 3) + koong(n - 4);
	}
}
