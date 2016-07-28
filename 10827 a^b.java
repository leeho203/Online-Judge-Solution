/*
 * https://www.acmicpc.net/problem/10827
 * BigDecimal
 */
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BigDecimal num1 = sc.nextBigDecimal();
		int num2 = sc.nextInt();
		// exponent로 나타나지 않기 위해 toPlainString() 메서드를 사용
		System.out.printf("%s", num1.pow(num2).toPlainString());
	}
}
