/*
 * https://www.acmicpc.net/problem/9093
 * 
 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < temp.length; j++) {
				for (int k = temp[j].length() - 1; k >= 0; k--) {
					bw.write(temp[j].charAt(k));
				}
				bw.write(" ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
