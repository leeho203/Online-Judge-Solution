import java.util.*;

public class Main {
	// 상하좌우로 움직일 때의 좌표를 담은 배열
	static int[] rdir = { -1, 0, 1, 0 };
	static int[] cdir = { 0, 1, 0, -1 };
	
	// 미로 입력받을 배열, 발견여부확인 배열
	static int[][] map;
	static int[][] discovered;

	// que에 넣어줄 Position객체를 내부클래스로 선언
	// Position객체는 현재 y좌표, 현재 x좌표, 출발점으로부터의 칸수를 담음
	static class Position {
		int yPos;
		int xPos;
		int dist;

		Position(int yPos, int xPos, int dist) {
			this.yPos = yPos;
			this.xPos = xPos;
			this.dist = dist;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		sc.nextLine();
		
		map = new int[y + 1][x + 1];
		discovered = new int[y + 1][x + 1];
		ArrayList<Position> que = new ArrayList<Position>();
		
		// 미로 정보를 입력받음
		for (int i = 1; i <= y; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j + 1] = Integer.parseInt(str.charAt(j) + "");
			}
		}

		// Position객체를 초기화해서 (1, 1)부터 시작하고 칸수는 1부터 시작
		Position startPosition = new Position(1, 1, 1);
		que.add(startPosition);
		// (1, 1)은 처음에 발견했다고 해줌
		discovered[1][1] = 1;
		
		while (!que.isEmpty()) {
			// 방문할 Position객체의 데이터를 각각의 변수에 저장
			Position data = que.get(0);
			int r = data.yPos;
			int c = data.xPos;
			int d = data.dist;
			
			// 발견한 정점을 실제로 방문해줌
			que.remove(0);

			// 도착지점에 도달하게 된다면 출발점으로부터의 칸수를 출력
			if (r == y && c == x) {
				System.out.println(d);
				break;
			}
			
			// 상하좌우 확인
			for (int i = 0; i < 4; i++) {
				int nr = r + rdir[i];
				int nc = c + cdir[i];
				
				// 미로 밖으로 나가지 못하게 함
				if (nr < 1 || nc < 1 || nr > y || nc > x)
					continue;
				
				// 길이 존재하고 아직 발견하지 않았다면 해당 좌표를 발견했다고 해줌
				if (map[nr][nc] == 1 && discovered[nr][nc] == 0) {
					discovered[nr][nc] = 1;
					Position pos = new Position(nr, nc, d + 1);
					que.add(pos);
				}
			}
		}
	}
}
