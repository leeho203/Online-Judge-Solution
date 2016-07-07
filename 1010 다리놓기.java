import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			result += combination(n, k) + "\n";
		}

		System.out.print(result);
	}
  
  	// 이 문제를 단순히 생각해보면 강 동쪽 사이트가 강 서쪽 사이트를 순서에 상관없이 선택하는 것과 같음
	static int combination(int n, int k) {
		if (k == n)
			return 1;
		if (k == 1)
			return n;
		return combination(n - 1, k) + combination(n - 1, k - 1);
	}
}
