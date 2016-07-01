import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			//	a는 1의 자리만 필요함
			a %= 10;
			
			//	결과값은 b의 승수에 의해 좌우됨
			//	b의 1승과 5승, 2승과 6승, 3승과 7승, 4승과 8승은 같은 결과값을 가짐
			//	결국 b는 1에서 4를 반복으로 같은 결과값을 가지므로 적절히 조정해줌
			b--;
			b %= 4;
			b++;
			
			int answer = (int) Math.pow(a, b) % 10;
			result += ((answer == 0) ? 10 : answer) + "\n";
		}
		System.out.print(result);
	}
}
