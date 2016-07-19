import java.util.*;

public class Main {
	static int[] data;
	static int[] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		data = new int[n + 1];
		cache = new int[n + 1];

		for (int i = 1; i <= m; i++)
			data[sc.nextInt()]++;
		
		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		int cnt = 0;
		int result = 1;
		for (int i = 1; i <= n; i++) {
			if (data[i] == 0)
				cnt++;
			if (data[i] == 1 || i == n) {
				result *= fibo(cnt);
				cnt = 0;
			}
		}

		System.out.println(result);
	}

	static int fibo(int n) {
		if (n == 0 || n == 1)
			return 1;
		if (cache[n] != -1)
			return cache[n];
		return cache[n] = fibo(n - 1) + fibo(n - 2);
	}
}
