/*
 * https://www.acmicpc.net/problem/1718
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String key = br.readLine();
		int keyLength = key.length();
		int keyPointer = 0;

		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// 알파벳 소문자라면 암호화
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				ch = (char) (str.charAt(i) - (key.charAt(keyPointer) - 96));
				if (ch < 'a')
					ch += 26;
			}
			
			bw.write(ch);
			
			// keyPointer를 활용해서 key를 str과 반복해서 비교해줌
			keyPointer++;
			if (keyPointer % keyLength == 0)
				keyPointer = 0;
		}

		bw.flush();
	}
}
