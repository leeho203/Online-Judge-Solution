import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		char[] ch = new char[26];
		for (int i = 0; i < t; i++) {
			String str = sc.nextLine();
			ch[str.charAt(0) - 97]++;
		}

		String result = "";
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 5)
				result += (char) (i + 97);
		}

		if (result.equals(""))
			System.out.println("PREDAJA");
		else
			System.out.println(result);
	}
}
