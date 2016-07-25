/*
 * https://www.acmicpc.net/problem/1919
 * 
 */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int[] alpha1 = new int[26];
		int[] alpha2 = new int[26];

		for (int i = 0; i < str1.length(); i++)
			alpha1[str1.charAt(i) - 97]++;

		for (int i = 0; i < str2.length(); i++)
			alpha2[str2.charAt(i) - 97]++;

		int sum = 0;
		for (int i = 0; i < 26; i++) {
			if (alpha1[i] == alpha2[i])
				continue;
			else
				sum += Math.abs(alpha1[i] - alpha2[i]);

		}
		
		System.out.println(sum);
	}
}
