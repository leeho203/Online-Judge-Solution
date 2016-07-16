import java.io.*;

public class Main {
	// DNA의 조합에 대한 결과를 담은 상수배열
	static final char[][] data = new char[][] { 
			{ 'A', 'C', 'A', 'G' }, 
			{ 'C', 'G', 'T', 'A' }, 
			{ 'A', 'T', 'C', 'G' },
			{ 'G', 'A', 'G', 'T' } 
	};
	static char[] ch;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ch = new char[n];
		String str = br.readLine();
		int len = str.length();

		for (int i = 0; i < len; i++)
			ch[i] = str.charAt(i);

		solution(len - 1);
		System.out.println(ch[0]);
	}
	
	// 맨 끝 Index부터 처음 Index까지 가면서 계산
	static void solution(int len) {
		if (len < 1)
			return;

		char chTemp[] = new char[2];
		int n[] = new int[2];
		chTemp[0] = ch[len];
		chTemp[1] = ch[len - 1];
		for (int i = 0; i <= 1; i++) {
			if (chTemp[i] == 'A')
				n[i] = 0;
			if (chTemp[i] == 'G')
				n[i] = 1;
			if (chTemp[i] == 'C')
				n[i] = 2;
			if (chTemp[i] == 'T')
				n[i] = 3;
		}
		
		// ch배열 갱신 후 len-1을 계속 비교함
		ch[len - 1] = data[n[0]][n[1]];
		solution(len - 1);
	}
}
