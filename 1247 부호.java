/*
 * https://www.acmicpc.net/problem/1247
 * BigInteger
 */
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = "";
		for (int i = 0; i < 3; i++) {
			int n = Integer.parseInt(br.readLine());
			BigInteger sum = new BigInteger("0");
			for (int j = 0; j < n; j++)
				sum = sum.add(new BigInteger(br.readLine()));
			result += (sum.signum() == -1) ? "-" : (sum.signum() == 1) ? "+" : "0";
			result += "\n";
		}
		
		System.out.print(result);
	}
}
