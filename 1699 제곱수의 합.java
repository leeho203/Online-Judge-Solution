/*
 * https://www.acmicpc.net/problem/1699
 * 동적계획법
 * 유사문제 : https://www.acmicpc.net/problem/1660, https://www.acmicpc.net/problem/2294
 */
import java.util.*;

public class Main {
	static int[] cache = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer> numList = new ArrayList<Integer>();
		int su = 1;
		for (int i = 2; su <= 100000; i++) {
			numList.add(su);
			su = (int) Math.pow(i, 2);
		}

		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		cache[0] = 0;

		for (int i = 0; i < numList.size(); i++) {
			for (int j = numList.get(i); j < cache.length; j++) {
				if (cache[j] == -1)
					cache[j] = cache[j - numList.get(i)] + 1;
				else
					cache[j] = Math.min(cache[j], cache[j - numList.get(i)] + 1);
			}
		}

		System.out.println(cache[n]);
	}
}
