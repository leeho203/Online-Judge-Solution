import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// 입력데이터를 저장할 배열 선언
		int[][] a = new int[n + 1][m + 1];
		
		// 동적계획법을 사용해서 저장해줄 배열 선언
		int[][] d = new int[n + 1][m + 1];

    // n * m 크기의 데이터 입력
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				a[i][j] = sc.nextInt();
    
    // 오른쪽 또는 아래쪽으로 내려오면서 가장 큰 값을 d배열에 저장해줌
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 1 && j == 1)
					d[1][1] = a[1][1];
				else
					d[i][j] = Math.max(d[i][j - 1] + a[i][j], d[i - 1][j] + a[i][j]);
			}
		}
  
    // n, m 지점에 내려왔을 때의 값이 max값임
		System.out.println(d[n][m]);

	}
}
