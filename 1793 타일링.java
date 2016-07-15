import java.util.*;
import java.math.*;

public class Main {

	// n이 0에서 250까지 가능하므로 BigInteger를 써야 계산 가능함
	static BigInteger[] dp = new BigInteger[251];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		
		// BigInteger는 String형식을 사용해서 계산하므로 메모이제이션보다는 반복문으로 구현
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		for (int i = 3; i < dp.length; i++)
			dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigInteger("2")));

		while (sc.hasNext()) {
			int n = sc.nextInt();
			result += dp[n] + "\n";
		}

		System.out.print(result);
	}
}
