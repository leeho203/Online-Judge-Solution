/*
 * https://www.acmicpc.net/problem/11656
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String temp = br.readLine();
		int len = temp.length();
		String[] strArr = new String[len];

		for (int i = 0; i < len; i++)
			strArr[i] = temp.substring(i);

		Arrays.sort(strArr);

		for (String str : strArr)
			bw.write(str + "\n");
		bw.flush();
	}
}
