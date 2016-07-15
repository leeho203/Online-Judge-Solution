import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer("");

		int t = Integer.parseInt(br.readLine());
		String result = "";
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] a = new int[n + 1][3];
			int[][] d = new int[n + 1][3];
			String[] temp1 = br.readLine().split(" ");
			String[] temp2 = br.readLine().split(" ");
			String[] temp = new String[temp1.length + temp2.length];
			System.arraycopy(temp1, 0, temp, 0, temp1.length);
			System.arraycopy(temp2, 0, temp, temp1.length, temp2.length);

			int c = 0;
			for (int j = 2; j >= 1; j--) {
				for (int k = 1; k <= n; k++) {
					a[k][j] = Integer.parseInt(temp[c]);
					c++;
				}
			}

			d[1][1] = a[1][1];
			d[1][2] = a[1][2];

			for (int j = 2; j <= n; j++) {
				for (int k = 1; k <= 2; k++) {
					if (k == 1)
						d[j][k] = Math.max(Math.max(d[j - 2][k] + a[j][k], d[j - 2][k + 1] + a[j][k]),
								d[j - 1][k + 1] + a[j][k]);
					else if (k == 2)
						d[j][k] = Math.max(Math.max(d[j - 2][k - 1] + a[j][k], d[j - 2][k] + a[j][k]),
								d[j - 1][k - 1] + a[j][k]);
				}
			}

			result += Math.max(d[n][1], d[n][2]) + "\n";

		}

		System.out.print(result);

	}
}
