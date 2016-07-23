/*
 * https://www.acmicpc.net/problem/2161
 * 
 */
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i <= n; i++)
			list.add(i);

		int i = 0;
		while (!list.isEmpty()) {
			int getNum = list.get(0);
			list.remove(0);
			if (i % 2 == 0)
				System.out.print(getNum + " ");
			else
				list.add(getNum);
			i++;
		}
	}
}
