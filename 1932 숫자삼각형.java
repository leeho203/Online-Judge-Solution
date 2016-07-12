import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// 동적계획법을 위한 배열 선언 -> 각 위치까지의 max값을 넣을 용도
		int[][] d = new int[501][501];
		// 데이터 입력을 위한 배열 선언
		int[][] a = new int[501][501];
		int n = sc.nextInt();
		int max = 0;

                // 삼각형 데이터 입력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				a[i][j] = sc.nextInt();
			}
		}
    
                // (1, 1)까지의 max값은 (1, 1)임
		d[1][1] = a[1][1];
    
                // (i, j)까지의 max값을 계산
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				d[i][j] = Math.max(d[i - 1][j - 1] + a[i][j], d[i - 1][j] + a[i][j]);
			}
		}
    
                // 삼각형의 가장 하단부의 max값을 구하면 삼각형의 최대가 되는 합을 구할수 있음
		for (int j = 1; j <= n; j++) {
			if (d[n][j] > max) {
				max = d[n][j];
			}
		}
		
		System.out.println(max);

	}
}
