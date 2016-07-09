import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int find = sc.nextInt();
		int findX = 0, findY = 0;
		
		int[][] arr = new int[n][n];
		int y = -1, x = 0;
		int s = 1;
		int num = n * n;

		while (num != 0) {
			for (int i = 0; i < n; i++) {
				y += s;
				arr[y][x] = num;
				if (num == find) {
					findY = y;
					findX = x;
				}
				num--;
			}

			n--;

			for (int i = 0; i < n; i++) {
				x += s;
				arr[y][x] = num;
				if (num == find) {
					findY = y;
					findX = x;
				}
				num--;
			}

			if (s == 1)
				s = -1;
			else if (s == -1)
				s = 1;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.printf("\n");
		}

		System.out.print((findY + 1) + " " + (findX + 1) + "\n");
	}
}
