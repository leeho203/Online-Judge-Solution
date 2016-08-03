/*
 * https://www.acmicpc.net/problem/7568
 * 배열
 */
import java.util.*;

public class Main {
	static class Location {
		private int y;
		private int x;

		Location(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] graph = new int[201][201];
		Location[] loc = new Location[n];

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			loc[i] = new Location(y, x);
			
			for (int p = y - 1; p >= 0; p--)
				for (int q = x - 1; q >= 0; q--)
					graph[p][q]++;
		}

		for (int i = 0; i < n; i++) {
			int y = loc[i].y;
			int x = loc[i].x;
			System.out.println(graph[y][x] + 1);
		}
	}
}
