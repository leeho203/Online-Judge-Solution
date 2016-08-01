/*
 * https://www.acmicpc.net/problem/1500
 * 
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		long k = sc.nextLong();
		long ans = 1;
		
		while (s > 0) {
			long tmp = (long) Math.ceil(s / (k * 1.0));
			ans *= tmp;
			s -= tmp;
			k--;
		}

		System.out.println(ans);
	}
}
