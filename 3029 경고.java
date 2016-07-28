/*
 * https://www.acmicpc.net/problem/3029
 * 
 */
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		int time1 = Integer.parseInt(str1.substring(0, 2)) * 3600 + Integer.parseInt(str1.substring(3, 5)) * 60
				+ Integer.parseInt(str1.substring(6, 8));
		int time2 = Integer.parseInt(str2.substring(0, 2)) * 3600 + Integer.parseInt(str2.substring(3, 5)) * 60
				+ Integer.parseInt(str2.substring(6, 8));
		int result = time2 - time1;

		// 적어도 1초 이상 기다려야 하므로 result = 0이어도 86400을 더해줌
		while (result <= 0)
			result += 86400;

		int h = result / 3600;
		result %= 3600;
		int m = result / 60;
		result %= 60;
		int s = result;
		System.out.printf("%02d:%02d:%02d\n", h, m, s);
	}
}
