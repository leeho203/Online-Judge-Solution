/*
 * https://www.acmicpc.net/problem/1947
 * 동적계획법
 */

import java.util.*;

public class Main {
	static long[] cache = new long[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cache[1] = 0;
		cache[2] = 1;

		for (int i = 3; i < cache.length; i++)
			cache[i] = ((i - 1) * (cache[i - 1] % 1000000000 + cache[i - 2] % 1000000000)) % 1000000000;
		System.out.println(cache[sc.nextInt()]);
	}
}
