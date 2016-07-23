/*
 * https://www.acmicpc.net/problem/11650
 * 다중정렬
 */
import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class PointComparator implements Comparator<Point> {
		@Override
		public int compare(Point p0, Point p1) {
			int result = p0.x - p1.x;
			if (p0.x == p1.x)
				result = p0.y - p1.y;
			return result;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Point[] point = new Point[n];

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			point[i] = new Point(y, x);
		}

		Arrays.sort(point, new PointComparator());

		for (Point p : point)
			bw.write(p.x + " " + p.y + "\n");

		bw.flush();
	}
}
