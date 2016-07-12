import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	        // n이 100,000개 이상이라 Scanner보다는 BufferedReader를 사용해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String temp = br.readLine();
		StringTokenizer st = new StringTokenizer(temp, " ");

		int psum = 0;
		int result = Integer.MIN_VALUE;
		
		// psum이 (-)가 되지 않도록 구간을 조절해서 더해줌
		// 결국, 연속합의 최대값은 psum의 최대값이 됨
		for (int i = 1; i <= n; i++) {
			int token = Integer.parseInt(st.nextToken());
			psum = Math.max(psum, 0) + token;
			result = Math.max(result, psum);
		}

		System.out.println(result);
	}
}
