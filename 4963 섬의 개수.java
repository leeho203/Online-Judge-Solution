import java.util.*;

public class Main {
	static int[][] map = new int[51][51];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		while (true) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (x == 0 && y == 0)
				break;

			for (int i = 0; i < map.length; i++)
				for (int j = 0; j < map[i].length; j++)
					map[i][j] = 0;

			for (int i = 1; i <= y; i++)
				for (int j = 1; j <= x; j++)
					map[i][j] = sc.nextInt();

			int cnt = 0;

			for (int i = 1; i <= y; i++) {
				for (int j = 1; j <= x; j++) {
					if (map[i][j] == 1) {
						cnt++;
						searchIsland(i, j);
					}
				}
			}
			result += cnt + "\n";
		}
		System.out.print(result);
	}

	static void searchIsland(int y, int x) {
		map[y][x] = 0;
		if (y >= 1 && map[y - 1][x] == 1)
			searchIsland(y - 1, x);
		if (y >= 1 && x < map.length - 1 && map[y - 1][x + 1] == 1)
			searchIsland(y - 1, x + 1);
		if (x < map.length - 1 && map[y][x + 1] == 1)
			searchIsland(y, x + 1);
		if (y < map.length - 1 && x < map.length - 1 && map[y + 1][x + 1] == 1)
			searchIsland(y + 1, x + 1);
		if (y < map.length - 1 && map[y + 1][x] == 1)
			searchIsland(y + 1, x);
		if (y < map.length - 1 && x >= 1 && map[y + 1][x - 1] == 1)
			searchIsland(y + 1, x - 1);
		if (x >= 1 && map[y][x - 1] == 1)
			searchIsland(y, x - 1);
		if (y >= 1 && x >= 1 && map[y - 1][x - 1] == 1)
			searchIsland(y - 1, x - 1);
	}
}
