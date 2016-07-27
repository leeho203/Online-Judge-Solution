/*
 * https://www.acmicpc.net/problem/11659
 * 메모이제이션
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int i = 1;
		int[] d = new int[n + 1];
		int[] a = new int[n + 1];

		String arrTemp = br.readLine();
		StringTokenizer st = new StringTokenizer(arrTemp, " ");
		while (st.hasMoreTokens()) {
			a[i] = Integer.parseInt(st.nextToken());
			i++;
		}

		d[1] = a[1];

		for (i = 2; i <= n; i++)
			d[i] = d[i - 1] + a[i];

		for (i = 1; i <= m; i++) {
			String strTemp = br.readLine();
			StringTokenizer stz = new StringTokenizer(strTemp, " ");
			int startNum = Integer.parseInt(stz.nextToken());
			int endNum = Integer.parseInt(stz.nextToken());
			bw.write((d[endNum] - d[startNum - 1]) + "\n");
		}
		
		bw.flush();
	}
}
