/*
 * https://www.acmicpc.net/problem/2979
 * 
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fareForOne = sc.nextInt();
		int fareForTwo = sc.nextInt() * 2;
		int fareForThree = sc.nextInt() * 3;
		int totalFare = 0;
		int[] data = new int[101];

		for (int i = 0; i < 3; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			for (int j = start; j < end; j++)
				data[j]++;
		}

		for (int i = 1; i < data.length; i++) {
			if (data[i] == 3)
				totalFare += fareForThree;
			else if (data[i] == 2)
				totalFare += fareForTwo;
			else if (data[i] == 1)
				totalFare += fareForOne;
		}

		System.out.println(totalFare);
	}
}
