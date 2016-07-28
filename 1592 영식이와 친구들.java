/*
 * https://www.acmicpc.net/problem/1592
 * 
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();

		int[] data = new int[n + 1];
		int index = 1;
		int cnt = 0;

		while (true) {
			data[index]++;
			if (data[index] < m) {
				cnt++;

				if (data[index] % 2 == 0)
					index -= l;
				else
					index += l;

				if (index > n)
					index -= n;
				else if (index < 1)
					index += n;
			} else
				break;
		}

		System.out.println(cnt);
	}
}
