/*
 * https://www.acmicpc.net/problem/2018
 * 
 */
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[n / 2 + 1];
		for (int i = 0; i < data.length; i++)
			data[i] = i + 1;

		int leftIndex = -1;
		int rightIndex = -1;
		int psum = 0;
		int cnt = 0;

		while (leftIndex <= rightIndex) {
			if (psum < n) {
				rightIndex++;
				if (rightIndex == data.length)
					break;
				psum += data[rightIndex];
			} else if (psum >= n) {
				leftIndex++;
				if (leftIndex == data.length)
					break;
				psum -= data[leftIndex];
			}

			if (psum == n)
				cnt++;
		}
		System.out.println(cnt + 1);
	}
}
