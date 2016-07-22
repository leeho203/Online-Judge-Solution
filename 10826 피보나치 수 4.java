/*
 * https://www.acmicpc.net/problem/10826
 * 동적계획법, BigInteger
 */
import java.math.BigInteger;
import java.util.*;

public class Main {
	static BigInteger[] cache = new BigInteger[10001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		cache[0] = new BigInteger("0");
		cache[1] = new BigInteger("1");
		cache[2] = new BigInteger("1");
                
                // n이 10000이하의 값을 가지므로 BigInteger객체를 사용
		for (int i = 3; i < cache.length; i++)
			cache[i] = cache[i - 1].add(cache[i - 2]);
		
		System.out.println(cache[num]);
	}
}
