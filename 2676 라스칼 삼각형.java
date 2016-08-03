/*
 * https://www.acmicpc.net/problem/2676
 * 등차수열
 */
import java.util.*;
import java.io.*;

public class Main {
        // 메모이제이션을 이용하려면 최소 12.5억 이상의 반복을 해야하고 
        // 메모이제이션 배열을 마련하는 것이 애초에 불가능하므로 공식을 찾아서 해결해야함
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] temp = br.readLine().split(" ");
			int r = Integer.parseInt(temp[0]);
			int c = Integer.parseInt(temp[1]);
			bw.write(rascal(r, c) + "\n");
		}

		bw.flush();
	}
        
        // 등차수열 공식을 변형
	static int rascal(int r, int c) {
		if (c == 0 || r == c)
			return 1;
		return 1 + (r - c) * c;
	}
}
