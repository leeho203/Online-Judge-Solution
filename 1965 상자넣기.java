import java.util.*;

public class Main {
	static int[] data;
	static int[] cache;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		data = new int[n + 1];
		cache = new int[n + 1];

		for (int i = 1; i <= n; i++)
			data[i] = sc.nextInt();

		for (int i = 0; i <= n; i++)
			cache[i] = -1;

		int max = 0;
		for (int i = 1; i <= n; i++)
			max = Math.max(max, LIS(i));
		System.out.println(max);
	}

	static int LIS(int here) {
		int result = 1;
		if (here == n)
			return 1;
		if (cache[here] != -1)
			return cache[here];
		for (int next = here + 1; next <= n; next++)
			if (data[here] < data[next])
				result = Math.max(result, 1 + LIS(next));
		return cache[here] = result;
	}
}
