/*
 * https://www.acmicpc.net/problem/2999
 * 배열
 */
import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int len = str.length();
		int rLen = 0;
		int cLen = 0;
		// r과 c의 크기 구하기
		for (int r = 1; r <= len; r++)
			for (int c = 1; c <= len; c++)
				if (r * c == len && r <= c) {
					rLen = r;
					cLen = c;
				}
		
		// 암호문 넣기
		char[][] data = new char[rLen][cLen];
		int strIdx = 0;
		for (int i = 0; i < data[0].length; i++) {
			for (int j = 0; j < data.length; j++) {
				data[j][i] = str.charAt(strIdx);
				strIdx++;
			}
		}

		// 암호문 해독하기
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[i].length; j++)
				System.out.print(data[i][j]);
	}
}
