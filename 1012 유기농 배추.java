import java.io.*;

public class Main {
	static int[][] map = new int[51][51];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String result = "";

		for (int i = 1; i <= t; i++) {
			// 배열 초기화
			for (int p = 0; p < map.length; p++)
				for (int q = 0; q < map[i].length; q++)
					map[p][q] = 0;

			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			int k = Integer.parseInt(temp[2]);
			int cnt = 0;
			
			// 배추 위치 등록
			for (int j = 1; j <= k; j++) {
				String[] locTemp = br.readLine().split(" ");
				int locX = Integer.parseInt(locTemp[0]);
				int locY = Integer.parseInt(locTemp[1]);
				map[locY][locX] = 1;
			}

			// DFS를 이용해 인접해있는 배추들이 있는 곳의 수 찾기
			for (int p = 0; p < y; p++) {
				for (int q = 0; q < x; q++) {
					if (map[p][q] == 1) {
						cnt++;
						DFS(p, q);
					}
				}
			}

			result += cnt + "\n";
		}

		System.out.print(result);
	}

	// 상하좌우 DFS탐색
	static void DFS(int y, int x) {
		map[y][x] = 0;

		if (y >= 1 && map[y - 1][x] == 1)
			DFS(y - 1, x);
		if (x < map.length && map[y][x + 1] == 1)
			DFS(y, x + 1);
		if (y < map[0].length && map[y + 1][x] == 1)
			DFS(y + 1, x);
		if (x >= 1 && map[y][x - 1] == 1)
			DFS(y, x - 1);

		return;
	}
}
