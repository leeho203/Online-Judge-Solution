import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		// a, b, c 모두 2,147,483,647까지 가능하므로 제곱을 빠르게 해줘야 함
		System.out.println(pow(a, b, c));
	}

	static long pow(long x, long y, long z) {
		if (y == 0)
			return 1;

		// pow(x, y) = pow(x, y/2) * f(x, y/2) where y % 2 == 0
		// pow(x, y) = x * pow(x, y/2) * f(x, y/2) where y % 2 == 1
		long d = pow(x, y / 2, z);

		if (y % 2 == 0)
			return (d % z * d % z) % z;
		else
			return (x % z * d % z * d % z) % z;
	}
}
