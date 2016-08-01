/*
 * https://www.acmicpc.net/problem/2852
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[][] score = new int[3][2880];
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			String[] temp = sc.nextLine().split(" ");
			int team = Integer.parseInt(temp[0]);
			String[] time = temp[1].split(":");
			int startTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

			for (int j = startTime; j < score[team].length; j++)
				score[team][j]++;
		}

		int winningTime1 = 0;
		int winningTime2 = 0;
		for (int i = 0; i < score[0].length; i++) {
			if (score[1][i] > score[2][i])
				winningTime1++;
			else if (score[1][i] < score[2][i])
				winningTime2++;
		}

		System.out.printf("%02d:%02d\n", winningTime1 / 60, winningTime1 % 60);
		System.out.printf("%02d:%02d\n", winningTime2 / 60, winningTime2 % 60);
	}
}
