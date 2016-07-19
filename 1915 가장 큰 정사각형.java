import java.util.*;

public class Main {
	static int[][] map;
	static int[][] cache;
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();

		map = new int[1001][1001];
		cache = new int[1001][1001];
		int max = 0;
		
		for (int i = 1; i <= n; i++) {
			String str = sc.nextLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j - 1) + "");
			}
		}

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++) {
				if (map[i - 1][j] == 1 && map[i][j - 1] == 1 && map[i - 1][j - 1] == 1)
					cache[i][j] = Math.min(Math.min(cache[i - 1][j], cache[i][j - 1]), cache[i - 1][j - 1]) + 1;
				else
					cache[i][j] = map[i][j];
				max = Math.max(max, cache[i][j]);
			}

		System.out.println(max);

	}
}
