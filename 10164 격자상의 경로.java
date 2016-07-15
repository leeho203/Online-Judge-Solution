import java.util.*;
import java.io.*;

public class Main {
	static int[][] data;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		int k = sc.nextInt();
		int indexY = 0, indexX = 0;
		data = new int[y + 1][x + 1];
		int n = 1;
		for (int i = 1; i <= y; i++) {
			for (int j = 1; j <= x; j++) {
				data[i][j] = n++;
				if (data[i][j] == k) {
					indexY = i;
					indexX = j;
				}
			}
		}

		if (k == 0) {
			indexY = 1;
			indexX = 1;
		}

		System.out.println(findWay(1, 1, indexX, indexY) * findWay(indexY, indexX, y, x));

	}

	static int findWay(int y, int x, int endY, int endX) {
		int result = 0;
		if (y > endY || x > endX)
			return 0;
		if (y == endY && x == endX)
			return 1;
		result = findWay(y + 1, x, endY, endX) + findWay(y, x + 1, endY, endX);
		return result;
	}
}
