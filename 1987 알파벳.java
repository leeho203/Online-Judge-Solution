import java.util.*;

public class Main {
	static char[][] board;
	static int[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.nextLine();

		board = new char[r][c];
		check = new int[26];

		for (int i = 0; i < r; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				board[i][j] = str.charAt(j);
			}
		}

		System.out.println(DFS(0, 0));

	}

        // (r, c)를 시작으로 DFS를 이용해서 알파벳 탐색
	static int DFS(int r, int c) {
		int result = 0;
		if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1)
			return 0;
                // 해당 알파벳 방문하지 않았으면 방문하도록 함
		if (check[board[r][c] - 'A'] == 0) {
			check[board[r][c] - 'A'] = 1;
			result = Math.max(result, 1 + DFS(r - 1, c));
			result = Math.max(result, 1 + DFS(r, c + 1));
			result = Math.max(result, 1 + DFS(r + 1, c));
			result = Math.max(result, 1 + DFS(r, c - 1));
			check[board[r][c] - 'A'] = 0;
		}

		return result;
	}
}
