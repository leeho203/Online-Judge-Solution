/*
 * https://www.acmicpc.net/problem/2292
 * 
 */
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
	}

	static int solution(int n) {
		int sum = 1;
		int i = 6;
		int cnt = 1;
		
		if (n == 1)
			return 1;

		while (sum < n) {
			sum += i;
			cnt++;
			i += 6;
		}

		return cnt;
	}
}
