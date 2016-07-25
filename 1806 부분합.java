/*
 * https://www.acmicpc.net/problem/1806
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int s = Integer.parseInt(temp[1]);
		int[] data = new int[n];

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		int i = 0;
		while (st.hasMoreTokens()) {
			data[i] = Integer.parseInt(st.nextToken());
			i++;
		}

		int partialSum = 0;
		int addIndex = -1, subIndex = -1;
		int minLen = 987654321;
		while (true) {
			if (partialSum < s) {
				addIndex++;
				partialSum += data[addIndex];
			} else {
				subIndex++;
				partialSum -= data[subIndex];
			}

			if (partialSum >= s)
				minLen = Math.min(minLen, addIndex - subIndex);

			if (addIndex >= data.length - 1 && partialSum <= s)
				break;
		}

		if (minLen < 987654321)
			System.out.println(minLen);
		else
			System.out.println(0);
	}
}
