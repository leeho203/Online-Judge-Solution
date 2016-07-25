/*
 * https://www.acmicpc.net/problem/1850
 * 유클리드 호제법
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		String result = "";
		long num1 = sc.nextLong();
		long num2 = sc.nextLong();
		long gcd = GCD(num1, num2);

		for (int i = 1; i <= gcd; i++)
			bw.write("1");

		bw.flush();

	}

	static long GCD(long num1, long num2) {
		if (num2 == 0)
			return num1;
		return GCD(num2, num1 % num2);
	}
}
