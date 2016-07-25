/*
 * https://www.acmicpc.net/problem/1373
 * 
 */
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		String result = "";

		int len = str.length();
		int mod = len % 3;

		if (mod == 1)
			bw.write(Integer.parseInt(str.charAt(0) + "") + "");

		if (mod == 2)
			bw.write(Integer.parseInt(str.charAt(0) + "") * 2 + Integer.parseInt(str.charAt(1) + "") + "");

		for (int i = mod; i < len; i += 3) {
			bw.write((Integer.parseInt(str.charAt(i) + "") * 4 + Integer.parseInt(str.charAt(i + 1) + "") * 2
					+ Integer.parseInt(str.charAt(i + 2) + "")) + "");
		}

		bw.flush();
	}
}
