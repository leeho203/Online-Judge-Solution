/*
 * https://www.acmicpc.net/problem/1350
 * 
 */
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] file = new long[n];
		for (int i = 0; i < n; i++)
			file[i] = sc.nextLong();
		long cluster = sc.nextLong();
		long cnt = 0;
		long result = 0;
		for (int i = 0; i < file.length; i++)
			cnt += (long) Math.ceil(file[i] * 1.0 / cluster);

		result = cnt * cluster;
		System.out.println(result);
	}
}
