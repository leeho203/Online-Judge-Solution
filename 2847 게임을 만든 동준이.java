/*
 * https://www.acmicpc.net/problem/2847
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] levelData = new int[n];
		for (int i = 0; i < n; i++)
			levelData[i] = sc.nextInt();

		int result = 0;
		// 배열 뒤에서 부터 검증해서 값 누적
		for (int i = n - 1; i > 0; i--) {
			if (levelData[i] <= levelData[i - 1]) {
				result += levelData[i - 1] - levelData[i] + 1;
				levelData[i - 1] = levelData[i] - 1;
			}
		}

		System.out.println(result);
	}
}
