import java.util.*;
import java.io.*;

public class Main {
	static int[] count = new int[3];
	static int n;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		// 데이터 입력받기
		for (int i = 0; i < arr.length; i++) {
			int j = 0;
			String str = br.readLine();
			st = new StringTokenizer(str, " ");
			while (st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
                
                // 카운트 시작
		countingPaper(arr);
                
                // -1, 0, 1로 채워진 종이의 개수 출력
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
	}

	static void countingPaper(int[][] arr) {
		int r = arr.length - 1;
		int c = arr[0].length - 1;
		int[] paperCount = new int[3];
		boolean isAllEqual = false;
		
		// 종이조각이 모두 똑같은 숫자로 구성되어 있는지 확인하기 위해 -1, 0, 1의 갯수를 세줌 
		for (int i = 0; i <= r; i++)
			for (int j = 0; j <= c; j++)
				paperCount[arr[i][j] + 1]++;

		// 종이조각이 모두 똑같은 숫자로 구성되어 있다면 isAllEqual은 true값을 가지고 메서드 종료 
		for (int i = 0; i < paperCount.length; i++) {
			if (paperCount[i] == arr.length * arr[0].length) {
				isAllEqual = true;
				break;
			}
		}
		
		// Basecase 조건 : 종이조각을 더이상 나눌 수 없거나 모든 종이조각이 동일한 숫자로 구성될 때
		if ((r == 0 && c == 0) || isAllEqual){
			count[arr[r][c] + 1]++;
			return;
		}

		// 종이를 9조각으로 잘라줌
		int[][] data1 = slicingPaper(arr, 1);
		int[][] data2 = slicingPaper(arr, 2);
		int[][] data3 = slicingPaper(arr, 3);
		int[][] data4 = slicingPaper(arr, 4);
		int[][] data5 = slicingPaper(arr, 5);
		int[][] data6 = slicingPaper(arr, 6);
		int[][] data7 = slicingPaper(arr, 7);
		int[][] data8 = slicingPaper(arr, 8);
		int[][] data9 = slicingPaper(arr, 9);

		// 잘라준 종이조각들을 다시 세준다
		countingPaper(data1);
		countingPaper(data2);
		countingPaper(data3);
		countingPaper(data4);
		countingPaper(data5);
		countingPaper(data6);
		countingPaper(data7);
		countingPaper(data8);
		countingPaper(data9);
	}

	// 종이조각을 9조각으로 만들어 2차원배열에 담기 위한 메서드
	static int[][] slicingPaper(int[][] arr, int num) {
		int r1 = 0;
		int r2 = arr.length * 1 / 3;
		int r3 = arr.length * 2 / 3;
		int c1 = 0;
		int c2 = arr[0].length * 1 / 3;
		int c3 = arr[0].length * 2 / 3;

		int r = 0, c = 0;
		if (num == 1) {
			r = r1;
			c = c1;
		} else if (num == 2) {
			r = r1;
			c = c2;
		} else if (num == 3) {
			r = r1;
			c = c3;
		} else if (num == 4) {
			r = r2;
			c = c1;
		} else if (num == 5) {
			r = r2;
			c = c2;
		} else if (num == 6) {
			r = r2;
			c = c3;
		} else if (num == 7) {
			r = r3;
			c = c1;
		} else if (num == 8) {
			r = r3;
			c = c2;
		} else if (num == 9) {
			r = r3;
			c = c3;
		}

		int rIndex = r;
		int cIndex = c;
		int[][] data = new int[arr.length / 3][arr[0].length / 3];
		for (int i = 0; i < data.length; i++) {
			cIndex = c;
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = arr[rIndex][cIndex];
				cIndex++;
			}
			rIndex++;
		}

		return data;
	}
}
