import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			result += locationNum(x1, y1, r1, x2, y2, r2) + "\n";
		}

		System.out.print(result);
	}

	static int locationNum(int x1, int y1, int r1, int x2, int y2, int r2) {
		// 원의 반지름을 내림차순으로 정렬
		if (r1 < r2) {
			int temp = r1;
			r1 = r2;
			r2 = temp;
		}

		double dist = Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0));

		if (dist <= r1) { // 큰 원 안에 작은 원의 중심이 있는 경우
			if (x1 == x2 && y1 == y2 && r1 == r2) // 원의 중심이 동일하고 반지름도 동일한 경우
				return -1;
			else if (dist + r2 < r1) // 작은 원의 중심이 큰 원 안에 있고 큰 원과 작은 원이 서로 접점이 없는 경우
				return 0;
			else if (dist + r2 == r1) // 작은 원의 중심이 큰 원 안에 있고 한 개의 접점을 가지는 경우
				return 1;
			else // 작은 원의 중심이 큰 원 안에 있고 두 개의 접점을 가지는 경우
				return 2;
		} else { // 큰 원 안에 작은 원의 중심이 없는 경우
			if (dist > r1 + r2) // 작은 원의 중심이 큰 원 밖에 있고 큰 원과 작은 원이 서로 접점이 없는 경우
				return 0;
			else if (dist == r1 + r2) // 작은 원의 중심이 큰 원 밖에 있고 한 개의 접점을 가지는 경우
				return 1;
			else // 작은 원의 중심이 큰 원 밖에 있고 두 개의 접점을 가지는 경우
				return 2;
		}
	}
}
