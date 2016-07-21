/*
 * https://www.acmicpc.net/problem/2011
 * 동적계획법
 */
import java.util.*;
import java.io.*;

public class Main {
	static int[] cache = new int[5001];
	static String str;
	static int len;
	static final int MOD = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		len = str.length();

		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		int result = 0;

		if (str.charAt(0) != '0')
			result = (result % MOD + solution(0) % MOD) % MOD;
		if ((str.charAt(0) == '2' && str.charAt(1) <= '6') || str.charAt(0) == '1')
			result = (result % MOD + solution(1) % MOD) % MOD;

		System.out.println(result);
	}

	static int solution(int index) {
		int result = 0;

		if (index == len - 1)
			return 1;

		if (cache[index] != -1)
			return cache[index];

		if (index + 1 < len)
			if (str.charAt(index + 1) != '0')
				result = (result % MOD + solution(index + 1) % MOD) % MOD;

		if (index + 2 < len)
			if ((str.charAt(index + 1) == '2' && str.charAt(index + 2) <= '6') || (str.charAt(index + 1) == '1'))
				result = (result % MOD + solution(index + 2) % MOD) % MOD;

		return cache[index] = result;
	}
}
