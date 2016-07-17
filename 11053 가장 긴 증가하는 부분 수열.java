import java.util.*;

public class Main {

	static int[] cache;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		cache = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		int max = 0;
		for (int i = 0; i < arr.length; i++)
			max = Math.max(max, lengthOfLIS(arr, i) + 1);

		System.out.println(max);
	}

        // 해당 Index를 포함하는 가장 긴 증가하는 부분 수열의 길이를 리턴하는 메서드
	static int lengthOfLIS(int[] arr, int index) {
		int len = arr.length;
		int max = 0;
		if (index == len - 1)
			return 0;
		if (cache[index] != -1)
			return cache[index];

		for (int nextIndex = index + 1; nextIndex < len; nextIndex++) {
			if (arr[nextIndex] > arr[index])
				max = Math.max(max, 1 + lengthOfLIS(arr, nextIndex));
		}

		return cache[index] = max;
	}
}
