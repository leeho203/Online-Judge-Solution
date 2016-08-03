/*
 * https://www.acmicpc.net/problem/2948
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		String[] dayString = new String[] { "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
		int[] month = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		Scanner sc = new Scanner(System.in);

		int d = sc.nextInt();
		int m = sc.nextInt();
		int result = 0;
		
		for (int i = 1; i < m; i++)
			result += month[i];
		
		result += d;
		result %= 7;
		
		System.out.println(dayString[result]);
	}
}
