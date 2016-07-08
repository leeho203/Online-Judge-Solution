import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] D = new int[num + 1]; // n칸까지 올라갔을 때의 최대값을 저장하는 배열
		int[] A = new int[num + 1]; // 입력값을 저장할 배열

		for (int i = 1; i <= num; i++)
			A[i] = sc.nextInt();

		// 계단이 1개 일 때 1개를 밟아야 최대값, 계단이 2개 일 때 2개를 밟아야 최대값
		D[1] = A[1];
		D[2] = A[1] + A[2];
		
		// 계단이 3개 이상일 때 n-2번과 n번째를 밟거나 n-3번, n-1번, n번째를 밟을 수 있음
		// 따라서 점화식은 D[i] = Math.max(D[i - 2] + A[i], D[i - 3] + A[i - 1] + A[i])가 됨
		for (int i = 3; i <= num; i++) {
			D[i] = Math.max(D[i - 2] + A[i], D[i - 3] + A[i - 1] + A[i]);
		}

		System.out.println(D[num]);
	}
}
