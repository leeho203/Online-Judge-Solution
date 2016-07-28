/*
 * https://www.acmicpc.net/problem/1021
 * 탐욕법, 큐
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> que1 = new ArrayList<Integer>();
		ArrayList<Integer> que2 = new ArrayList<Integer>();
		ArrayList<Integer> que3 = new ArrayList<Integer>();
		ArrayList<Integer> target = new ArrayList<Integer>();

		for (int i = 1; i <= n; i++)
			que1.add(i);

		for (int i = 0; i < m; i++)
			target.add(sc.nextInt());

		int cnt = 0;
		
		// 부분의 최소연산수가 전체의 최소연산수이므로 탐욕법을 사용해서 구한다
		while (m > 0) {
			int seek = target.get(0);
			que2.clear();
			que3.clear();
			que2.addAll(que1);
			que3.addAll(que1);
			int que2Cnt = 0;
			int que3Cnt = 0;

			// 2번 연산의 횟수 구하기
			while (que2.get(0) != seek) {
				que2Cnt++;
				que2.add(que2.get(0));
				que2.remove(0);
			}

			// 3번 연산의 횟수 구하기
			while (que3.get(0) != seek) {
				que3Cnt++;
				que3.add(0, que3.get(que3.size() - 1));
				que3.remove(que3.size() - 1);
			}
			
			// 작은 연산을 보이는 방법을 선택해서 que1에 commit하는 방식
			if (que2Cnt < que3Cnt) {
				cnt += que2Cnt;
				que1.clear();
				que1.addAll(que2);
			} else {
				cnt += que3Cnt;
				que1.clear();
				que1.addAll(que3);
			}

			que1.remove(0);
			target.remove(0);
			m--;
		}

		System.out.println(cnt);
	}
}
