/*
 * https://www.acmicpc.net/problem/1246
 * 
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] data = new int[m];

		for (int i = 0; i < data.length; i++)
			data[i] = sc.nextInt();

		Arrays.sort(data);

		int searchIndex = Math.max(0, data.length - n);
		int maxPrice = 0;
		int maxRevenue = 0;
		for (int i = data.length - 1; i >= searchIndex; i--) {
			int revenue = data[i] * (data.length - i);
			if (maxRevenue < revenue) {
				maxRevenue = revenue;
				maxPrice = data[i];
			}
		}

		System.out.println(maxPrice + " " + maxRevenue);
	}
}
