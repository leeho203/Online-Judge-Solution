import java.util.*;

/* 
 * 조건 1. 알파벳을 카운트 했을 때 홀수로 카운팅되는 알파벳 종류는 하나이하여야함
 * 조건 2. 알파벳을 카운트 했을 때 홀수로 카운팅되는 알파벳 종류는 무조건 가운데에 들어가야함 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		String str = sc.nextLine();

		// 알파벳 갯수 카운트
		for (int i = 0; i < str.length(); i++)
			arr[str.charAt(i) - 65]++;

		// 펠린드롬을 세 부분으로 나눠서 만들어줌
		int cnt = 0;
		String first = "";
		String second = "";
		String third = "";

		// 사전 순으로 가장 빠른 펠린드롬을 만들어주려고 A ~ Z로 확인 
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				// 알파벳 카운트가 짝수라면 갯수의 절반 만큼을 first로 누적
				// 알파벳 카운트가 홀수라면 갯수의 절반 - 1 만큼을 first로 누적
				if (arr[i] % 2 == 0) {
					while (arr[i] > 0) {
						first += (char) (i + 65);
						arr[i] -= 2;
					}
				} else {
					while (arr[i] > 1) {
						first += (char) (i + 65);
						arr[i] -= 2;
					}
				}
			}

			if (arr[i] % 2 != 0)
				cnt++;
			// 알파벳 카운트가 홀수여서 남은 갯수 하나를 second로 저장
			if (cnt <= 1 && arr[i] > 0)
				second += (char) (i + 65);
		}

		// third는 first를 거꾸로 뒤집어서 누적
		for (int i = first.length() - 1; i >= 0; i--)
			third += first.charAt(i);

		if (cnt <= 1)
			System.out.print(first + second + third + "\n");
		else
			System.out.print("I'm Sorry Hansoo\n");
	}
}
