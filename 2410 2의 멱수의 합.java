/*
 * https://www.acmicpc.net/problem/2410
 * 동적계획법
 */
import java.util.*;

public class Main {
	static int[] twoSquare = new int[21];
	static int[] num = new int[1000001];
	static final int MOD = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 1; i < twoSquare.length; i++)
			twoSquare[i] = (int) Math.pow(2, i - 1);

		num[0] = 1;

		for (int i = 1; i < twoSquare.length; i++)
			for (int j = twoSquare[i]; j < num.length; j++)
				num[j] = (num[j] % MOD + num[j - twoSquare[i]] % MOD) % MOD;

		System.out.println(num[n]);
	}
}
