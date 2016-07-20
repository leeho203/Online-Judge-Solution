import java.util.*;

public class Main {
	// [기차종류][끝 인덱스] 일 때 운송할 수 있는 최대 손님 수
	static int[][] train = new int[4][50001];
	// partialSum을 저장할 배열
	static int[] trainSum = new int[50001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int trainNum = sc.nextInt();

		for (int i = 1; i <= trainNum; i++)
			trainSum[i] += trainSum[i - 1] + sc.nextInt();

		int maxTrain = sc.nextInt();

		// 3대의 소형기관차
		for (int i = 1; i <= 3; i++) {
			for (int j = i * maxTrain; j <= trainNum; j++) {
				// 현재 트레인이 j를 끝 인덱스로 할 때 운송할 수 있는 최대 승객 수
				// = 현재 트레인이 j를 끝 인덱스로 할 때 운송할 수 있는 승객 수 + 현재 트레인이 j를 끝 인덱스로 할 때 이전 트레인이 운송할 수 있었던 최대 손님 수
				train[i][j] = (trainSum[j] - trainSum[j - maxTrain]) + train[i - 1][j - maxTrain];
				// 현재 트레인이 j를 끝 인덱스로 할 때 운송할 수 있는 최대승객 수를 배열에 유지할 수 있도록 함
				train[i][j] = Math.max(train[i][j], train[i][j - 1]);
			}
		}

		System.out.println(train[3][trainNum]);
	}
}
