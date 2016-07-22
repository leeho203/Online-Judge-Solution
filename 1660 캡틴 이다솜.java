/*
 * https://www.acmicpc.net/problem/1660
 * 동적계획법
 */
import java.util.*;

public class Main {
	static ArrayList<Integer> tetrahedron = new ArrayList<Integer>();
	static int[] cache = new int[300001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		int num = 1;
		int num1 = 1;
		for (int i = 2; num1 <= 300000; i++) {
			tetrahedron.add(num1);
			num += i;
			num1 += num;
		}

		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		cache[0] = 0;
		for (int i = 0; i < tetrahedron.size(); i++)
			for (int j = tetrahedron.get(i); j < cache.length; j++) {
				if (cache[j] == -1)
					cache[j] = cache[j - tetrahedron.get(i)] + 1;
				else
					cache[j] = Math.min(cache[j], cache[j - tetrahedron.get(i)] + 1);
			}
		System.out.println(cache[k]);
	}
}
