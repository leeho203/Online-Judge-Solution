/*
 * https://www.acmicpc.net/problem/9517
 * 
 */
import java.util.*;

public class Main {
	static final int LIMIT = 210;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int totalTime = 0;
		boolean isFirst = true;
		int result = k;

		for (int i = 1; i <= n; i++) {
			int time = sc.nextInt();
			char answer = sc.next().charAt(0);

			totalTime += time;
                        
                        // totalTime이 LIMIT를 넘어선 최초의 사람을 구해서 result에 저장
			if (totalTime > LIMIT && isFirst == true) {
				result = k;
				isFirst = false;
			}

			if (answer == 'T') {
				k++;
				if (k > 8)
					k = 1;
			}
		}

		if (totalTime > LIMIT)
			System.out.println(result);
	}
}
