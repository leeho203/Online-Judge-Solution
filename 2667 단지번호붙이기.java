import java.util.*;

public class Main {
	static int[] danji = new int[626];
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[26][26];
		sc.nextLine();

		// 데이터 입력받기
		for (int i = 1; i <= n; i++) {
			String temp = sc.nextLine();
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(temp.charAt(j - 1) + "");
			}
		}

                // (i, j) 좌표부터 시작해서 해당 값이 1이라면 단지 수를 카운트 해주고 방문했다고 설정(0으로 초기화)
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1) {
					cnt++;
					search(map, i, j);
				}
			}
		}

		System.out.println(cnt);
		Arrays.sort(danji);
		
		for (int i = danji.length - cnt; i < danji.length; i++)
			System.out.println(danji[i]);
	}
    
        // DFS를 이용해 4방향 점검
	static void search(int[][] map, int y, int x) {
		danji[cnt]++;
		map[y][x] = 0;
		if (y >= 1 && map[y - 1][x] == 1)
			search(map, y - 1, x);
		if (x < map.length - 1 && map[y][x + 1] == 1)
			search(map, y, x + 1);
		if (y < map.length - 1 && map[y + 1][x] == 1)
			search(map, y + 1, x);
		if (x >= 1 && map[y][x - 1] == 1)
			search(map, y, x - 1);
	}
}
