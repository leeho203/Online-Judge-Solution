import java.util.*;

public class Main {
	static int n;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		int[][] arr = new int[n][n];
		
		// 데이터 입력받기
		for (int i = 0; i < arr.length; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++)
				arr[i][j] = Integer.parseInt(str.charAt(j) + "");
		}

		countingPaper(arr);

	}

	static void countingPaper(int[][] arr) {
		int r = arr.length - 1;
		int c = arr[0].length - 1;
		int[] paperCount = new int[2];
		boolean isAllEqual = false;

		// 종이조각이 모두 똑같은 숫자로 구성되어 있는지 확인하기 위해 0, 1의 갯수를 세줌
		for (int i = 0; i <= r; i++)
			for (int j = 0; j <= c; j++)
				paperCount[arr[i][j]]++;

		// 종이조각이 모두 똑같은 숫자로 구성되어 있다면 isAllEqual은 true값을 가지고 메서드 종료
		for (int i = 0; i < paperCount.length; i++) {
			if (paperCount[i] == arr.length * arr[0].length) {
				isAllEqual = true;
				break;
			}
		}

		// basecase조건 : 종이조각을 더이상 나눌 수 없거나 모든 종이조각이 동일한 숫자로 구성될 때
		if ((r == 0 && c == 0) || isAllEqual) {
			System.out.print(arr[r][c]);
			return;
		}

		// 종이조각을 4면으로 잘라줌
		int[][] data1 = slicingPaper(arr, 1);
		int[][] data2 = slicingPaper(arr, 2);
		int[][] data3 = slicingPaper(arr, 3);
		int[][] data4 = slicingPaper(arr, 4);

		System.out.print("(");

		// 잘라준 종이조각들을 다시 세준다
		countingPaper(data1);
		countingPaper(data2);
		countingPaper(data3);
		countingPaper(data4);

		System.out.print(")");

	}

	// 종이조각을 4조각으로 만들어 2차원배열에 담기 위한 메서드
	static int[][] slicingPaper(int[][] arr, int num) {
		int r1 = 0;
		int r2 = arr.length * 1 / 2;
		int c1 = 0;
		int c2 = arr[0].length * 1 / 2;

		int r = 0, c = 0;
		if (num == 1) {
			r = r1;
			c = c1;
		} else if (num == 2) {
			r = r1;
			c = c2;
		} else if (num == 3) {
			r = r2;
			c = c1;
		} else if (num == 4) {
			r = r2;
			c = c2;
		}

		int rIndex = r;
		int cIndex = c;
		int[][] data = new int[arr.length / 2][arr[0].length / 2];
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
