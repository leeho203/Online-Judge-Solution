import java.util.*;

public class Main {
	static int n, s;
	static int cnt = 0;
	static int[] data;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		data = new int[n];
		for (int i = 0; i < n; i++)
			data[i] = sc.nextInt();

		sumOfSubset(0, 0, false);
		System.out.println(cnt);
	}

	static void sumOfSubset(int index, int sum, boolean choose) {
		if (choose == true && sum == s)
			cnt++;
		if (index >= n)
			return;
		sumOfSubset(index + 1, sum + data[index], true);
		sumOfSubset(index + 1, sum, false);
	}
}
