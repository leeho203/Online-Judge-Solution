import java.util.*;
import java.io.*;

public class Main {
	static long[] cache;
        
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		cache = new long[n + 1];
		for (int i = 0; i < cache.length; i++)
			cache[i] = -1;

		System.out.println(tiling(n));
	}
        
        /* 
        2×1타일은 경우의 수 1가지(세로막대 1개), 2×2타일은 경우의 수 3가지(가로막대 2개, 세로막대 2개, 정사각형 1개)로 채울 수 있음
        2×n타일은 2×1타일 + 2×(n-1)타일로 채울 수 있고, 2×2타일 + 2×(n-2)타일로 채울 수 있음
        2×1타일 + 2×(n-1)타일로 채울 수 있는 경우의 수는 1가지, 2×2타일 + 2×(n-2)타일로 채울 수 있는 경우의 수는 2가지
        그렇기 때문에 점화식은 f(n) = f(n-1) + 2 × f(n-2) 형태로 됨
        */
	static long tiling(int n) {
		long result = 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 3;
		if (cache[n] != -1)
			return cache[n];

		result = (tiling(n - 1) + tiling(n - 2) + tiling(n - 2)) % 10007;
		return cache[n] = result;
	}
}
