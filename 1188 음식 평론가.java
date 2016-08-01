/*
 * https://www.acmicpc.net/problem/1188
 * 유클리드 호제법
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		// n < m 일때, n명에게 m을 나눠주는 커팅 횟수는 m - GCD(n, m)회
		System.out.println(m - gcd(n, m));
	}

	static int gcd(int num1, int num2) {
		if (num2 == 0)
			return num1;
		return gcd(num2, num1 % num2);
	}
}
