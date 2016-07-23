/*
 * https://www.acmicpc.net/problem/2846
 * 동적계획법
 */
import java.util.*;

public class Main {
	static int[] data = new int[1001];
	static int[] cache = new int[1001];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;

		for (int i = 0; i < n; i++)
			data[i] = sc.nextInt();

		cache[0] = 0;

		for (int i = 1; i < n; i++) {
			if (data[i] > data[i - 1])
				cache[i] = cache[i - 1] + data[i] - data[i - 1];
			else
				cache[i] = 0;
			max = Math.max(max, cache[i]);
		}

		System.out.println(max);
	}
}
