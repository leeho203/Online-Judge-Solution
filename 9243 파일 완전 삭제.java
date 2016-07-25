/*
 * https://www.acmicpc.net/problem/9243
 * 
 */
import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String str3 = "";
		int len = str1.length();

                // str1의 보수를 구해서 str3에 넣어줌
		for (int j = 0; j < len; j++) {
			char ch = str1.charAt(j);
			if (ch == '0')
				str3 += '1';
			else if (ch == '1')
				str3 += '0';
		}
                
                // n번 만큼 반복해서 보수를 구하는 작업
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < len; j++) {
				char ch = str3.charAt(j);
				if (ch == '0')
					str3 = str3.substring(0, j) + '1' + str3.substring(j + 1, len);
				else if (ch == '1')
					str3 = str3.substring(0, j) + '0' + str3.substring(j + 1, len);
			}
		}
                
		boolean isRight = true;
		for (int i = 0; i < len; i++)
			if (str3.charAt(i) != str2.charAt(i))
				isRight = false;

		if (isRight)
			System.out.println("Deletion succeeded");
		else
			System.out.println("Deletion failed");

	}
}
