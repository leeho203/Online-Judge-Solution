/*
 * https://www.acmicpc.net/problem/2355
 * 연속합, BigInteger
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long start = sc.nextLong();
		long end = sc.nextLong();
		
		if (start > end) {
			long temp = start;
			start = end;
			end = temp;
		}

		// int 범위의 제곱연산을 수행해야 하므로 BigInteger를 써서 산술오버플로우를 해결
		BigInteger big1 = new BigInteger((end - start + 1) + "");
		BigInteger big2 = new BigInteger((end + start) + "");
		BigInteger result = big1.multiply(big2).divide(new BigInteger("2"));

		System.out.println(result);
	}
}
