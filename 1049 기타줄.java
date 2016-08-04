/*
 * https://www.acmicpc.net/problem/1049
 * 
 */
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = Integer.MAX_VALUE;
		int minSix = Integer.MAX_VALUE;
		int minOne = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			minSix = Math.min(minSix, sc.nextInt());
			minOne = Math.min(minOne, sc.nextInt());
		}

                // 1개 짜리로만 사는 경우, 6개 짜리로만 사는 경우, 1개 + 6개 짜리 조합해서 사는 경우 중에 가장 최소값
		result = Math.min((n / 6) * minSix + (n % 6) * minOne, Math.min(n * minOne, (n / 6 + 1) * minSix));
		System.out.println(result);
	}
}
