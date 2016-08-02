/*
 * https://www.acmicpc.net/problem/10816
 * 해쉬 맵
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		while (st.hasMoreTokens()) {
			int key = Integer.parseInt(st.nextToken());
			if (map.containsKey(key))
				map.replace(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}

		int m = Integer.parseInt(br.readLine());
		str = br.readLine();
		st = new StringTokenizer(str, " ");
		while(st.hasMoreTokens()){
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key))
				bw.write(map.get(key)+" ");
			else
				bw.write("0 ");
		}
		
		bw.flush();
	}
}
