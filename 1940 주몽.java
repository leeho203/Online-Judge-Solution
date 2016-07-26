/*
 * https://www.acmicpc.net/problem/1940
 * 
 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] data = new int[n];

		// n개의 데이터 입력 받기
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 0; i < n; i++)
			data[i] = Integer.parseInt(st.nextToken());

		// 오름차순으로 정렬
		Arrays.sort(data);
		int left = 0;
		int right = data.length - 1;
		int cnt = 0;

		// 정렬된 데이터를 left와 right 인덱스를 사용하면서 합이 m인 것을 찾음
		while (left < right) {
			/* 
			 * 두 합이 m보다 크거나 같으면 right를 왼쪽으로 이동
			 * 두 합이 m보다 작으면 left를 오른쪽으로 이동
			 * 두 합이 m과 같으면 카운트 해줌
			 */
			if (data[left] + data[right] > m)
				right--;
			else if (data[left] + data[right] < m)
				left++;
			else {
				cnt++;
				right--;
			}
		}

		System.out.println(cnt);
	}
}
