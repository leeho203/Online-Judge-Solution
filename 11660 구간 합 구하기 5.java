/*
 * https://www.acmicpc.net/problem/11660
 * 구간 합
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int[][] data = new int[n + 1][n + 1];
		int[][] psum = new int[n + 1][n + 1];

		// 가로 y, 세로 x로 된 배열을 가로 x, 세로 y로 된 배열로 입력받기
		for (int i = 1; i < data.length; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 1; j < data[i].length; j++)
				data[j][i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < psum.length; i++)
			for (int j = 1; j < psum[i].length; j++)
				psum[i][j] = data[i][j] + psum[i][j - 1] + psum[i - 1][j] - psum[i - 1][j - 1];

		for (int i = 1; i <= m; i++) {
			String[] str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			bw.write((psum[y2][x2] - psum[y2][x1 - 1] - psum[y1 - 1][x2] + psum[y1 - 1][x1 - 1]) + "\n");
		}
		
		bw.flush();
	}
}
