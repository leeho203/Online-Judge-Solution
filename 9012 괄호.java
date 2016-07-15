import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String result = "";
		sc.nextLine();
		for (int i = 1; i <= n; i++) {
			String str = sc.nextLine();
			if (isMatched(str))
				result += "YES\n";
			else
				result += "NO\n";
		}
		System.out.print(result);
	}

	static boolean isMatched(String str) {
		Stack st = new Stack();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				st.push('(');
			} else if (str.charAt(i) == ')') {
				if (st.isEmpty())
					return false;
				if ((Character) st.peek() != '(')
					return false;
				st.pop();
			}
		}
		return st.isEmpty();
	}
}
