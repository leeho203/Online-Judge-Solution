/*
 * https://www.acmicpc.net/problem/1018
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] board = new int[n][m];

		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				board[i][j] = (str.charAt(j) == 'B') ? 1 : 0;
			}
		}
		int min = Integer.MAX_VALUE;
		int cntEven = 0;
		int cntOdd = 0;
		int kEven = 0;
		int kOdd = 0;
		for (int p = 0; p <= board.length - 8; p++) {
			for (int q = 0; q <= board[p].length - 8; q++) {
				cntEven = 0;
				cntOdd = 0;
				for (int i = p; i < p + 8; i++) {
					for (int j = q; j < q + 8; j++) {
						kEven = (i + j) % 2;
						kOdd = (i + j + 1) % 2;
						if (board[i][j] != kEven)
							cntEven++;
						if (board[i][j] != kOdd)
							cntOdd++;
					}
				}
				min = Math.min(min, Math.min(cntEven, cntOdd));
			}
		}

		System.out.println(min);
	}
}
