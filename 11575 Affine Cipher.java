/*
 * https://www.acmicpc.net/problem/11575
 * 
 */
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		String result = "";

		for (int i = 0; i < t; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++)
				bw.write(getChar(str.charAt(j), a, b));
			bw.write("\n");
		}

		bw.flush();
	}

	static char getChar(char ch, int a, int b) {
		return (char) (((a * (ch - 65) + b) % 26) + 65);
	}
}
