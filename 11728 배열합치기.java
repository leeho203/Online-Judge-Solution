import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
	
	  // input과 output이 최대 2백만개이므로 BufferedReader와 BufferedWriter를 써야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] temp = br.readLine().split(" ");
		int lenA = Integer.parseInt(temp[0]);
		int lenB = Integer.parseInt(temp[1]);
		int[] arrA = new int[lenA];
		int[] arrB = new int[lenB];

		String tempA = br.readLine();
		StringTokenizer stA = new StringTokenizer(tempA, " ");
		int i = 0;
		while (stA.hasMoreTokens()) {
			arrA[i] = Integer.parseInt(stA.nextToken());
			i++;
		}

		String tempB = br.readLine();
		StringTokenizer stB = new StringTokenizer(tempB, " ");
		i = 0;
		while (stB.hasMoreTokens()) {
			arrB[i] = Integer.parseInt(stB.nextToken());
			i++;
		}

		int iA = 0;
		int iB = 0;
		
		// 병합정렬 알고리즘 사용
		while (iA < lenA && iB < lenB) {
			if (arrA[iA] > arrB[iB]) {
				bw.write(arrB[iB] + " ");
				iB++;
			} else {
				bw.write(arrA[iA] + " ");
				iA++;
			}
		}

		while (iA < lenA) {
			bw.write(arrA[iA] + " ");
			iA++;
		}

		while (iB < lenB) {
			bw.write(arrB[iB] + " ");
			iB++;
		}

		bw.flush();
	}
}
