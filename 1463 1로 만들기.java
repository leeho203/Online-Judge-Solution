import java.util.*;

public class Main {
  	// 동적계획법 적용을 위한 배열 선언
	// N의 범위가 10의 6승까지이므로 1,000,001의 공간을 마련해줌
	static int[] dp = new int[1000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
  
		for (int i = 0; i < dp.length; i++)
			dp[i] = -1;

		System.out.print(operation(n));
	}
	
	// 숫자 n에 대한 최소 연산횟수를 출력하는 함수
	static int operation(int n) {
		int result = Integer.MAX_VALUE;
    
    		// Basecase에 대한 조건을 마련해서 탈출조건으로 사용함
		// 아래의 Math.min 메서드에서 횟수를 처리해주니 Basecase는 0을 리턴하도록 해야함
		if (n == 1)
			return 0;
  
    		// 동적계획법으로 미리 답을 마련해두었다면(-1이 아니라면) 해당 답을 가져다 씀
		if (dp[n] != -1)
			return dp[n];
		if (n % 3 == 0)
			result = Math.min(result, 1 + operation(n / 3));
		if (n % 2 == 0)
			result = Math.min(result, 1 + operation(n / 2));
		result = Math.min(result, 1 + operation(n - 1));
		
    		// 세 가지의 연산방법 중에 최소연산횟수를 동적계획법 배열에 저장해두고 리턴함
    		// 이러한 트릭을 이용해서 완전탐색의 결과를 동적계획법으로 바꾸어 시간복잡도를 현저하게 감소시킬 수 있음
		return dp[n] = result;
	}
}
