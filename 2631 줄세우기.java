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

		System.out.println(n - max);

	}

	static int LIS(int start) {
		int max = 1;
		if (start == n)
			return 1;
		if (cache[start] != -1)
			return cache[start];
		for (int next = start + 1; next <= n; next++)
			if (data[start] < data[next])
				max = Math.max(max, 1 + LIS(next));
		return cache[start] = max;
	}
}
