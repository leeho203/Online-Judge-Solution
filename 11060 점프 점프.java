import java.util.*;

public class Main {
	// 동적계획법 사용할 배열
	static int[] d;
	// 데이터 입력할 배열
	static int[] a;
	// 매우 큰 값을 선언하여 도달할 수 없는 거리를 나타냄
	static final int INF = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n + 1];
		a = new int[n + 1];
		for (int i = 1; i <= n; i++)
			a[i] = sc.nextInt();
		for (int i = 0; i < d.length; i++)
			d[i] = -1;
			
		// n이 1이라면 무조건 0이 답이 됨
		if (n == 1)
			System.out.println(0);
		else if (jump(1) < INF)
			System.out.println(jump(1));
		else
			System.out.println(-1);

	}

	// 해당 인덱스에서부터 시작해서 최소 몇 번만에 도착하는 지를 리턴하는 완전탐색 알고리즘
	static int jump(int n) {
		int min = INF;
		if (n >= a.length - 1)
			return 0;
		if (d[n] != -1)
			return d[n];
		for (int i = 1; i <= a[n]; i++)
			min = Math.min(min, 1 + jump(n + i));
		return d[n] = min;
	}
}
