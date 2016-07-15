import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n + 1][4];
		int[][] d = new int[n + 1][4];
		int[][] e = new int[n + 1][4];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		d[1][1] = a[1][1];
		d[1][2] = a[1][2];
		d[1][3] = a[1][3];

		e[1][1] = a[1][1];
		e[1][2] = a[1][2];
		e[1][3] = a[1][3];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 3; j++) {
				if (j == 1) {
					d[i][j] = Math.max(d[i - 1][j] + a[i][j], d[i - 1][j + 1] + a[i][j]);
					e[i][j] = Math.min(e[i - 1][j] + a[i][j], e[i - 1][j + 1] + a[i][j]);
				} else if (j == 2) {
					d[i][j] = Math.max(Math.max(d[i - 1][j - 1] + a[i][j], d[i - 1][j] + a[i][j]),
							d[i - 1][j + 1] + a[i][j]);
					e[i][j] = Math.min(Math.min(e[i - 1][j - 1] + a[i][j], e[i - 1][j] + a[i][j]),
							e[i - 1][j + 1] + a[i][j]);
				} else {
					d[i][j] = Math.max(d[i - 1][j - 1] + a[i][j], d[i - 1][j] + a[i][j]);
					e[i][j] = Math.min(e[i - 1][j - 1] + a[i][j], e[i - 1][j] + a[i][j]);
				}
			}
		}

		System.out.print(Math.max(Math.max(d[n][1], d[n][2]), d[n][3]) + " ");
		System.out.print(Math.min(Math.min(e[n][1], e[n][2]), e[n][3]));
	}
}
