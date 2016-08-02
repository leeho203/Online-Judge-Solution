/*
 * https://www.acmicpc.net/submit/2805
 * 이진 탐색
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n, m 입력 받기
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		
		int[] tree = new int[n];
		int max = Integer.MIN_VALUE;

		// 나무 데이터 입력 받기
		String data = br.readLine();
		StringTokenizer st = new StringTokenizer(data, " ");
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}

		// h 범위의 이진탐색을 위한 로직
		long lbound = 1;
		long ubound = max;
		long middle = 0;
		long result = 0;
		while (lbound <= ubound) {
			long sum = 0;
			middle = (lbound + ubound) / 2;
			for (int i = 0; i < n; i++) {
				if (tree[i] > middle)
					sum += (tree[i] - middle);
			}

			// h가 너무 낮아서 많이 깎음 -> lbound를 늘려줌
			if (sum > m) {
				lbound = middle + 1;
				result = (lbound + ubound) / 2;
			// h가 너무 높아서 적게 깎음 -> ubound를 줄여줌
			} else if (sum < m) {
				ubound = middle - 1;
				result = (lbound + ubound) / 2;
			// h가 정답일 경우
			} else {
				result = middle;
				break;
			}
		}

		System.out.println(result);
	}
}
