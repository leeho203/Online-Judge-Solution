import java.util.*;

public class Main {
	static int bridgeLen, strLen;
	static char[] carvedStr;
	static char[] bridge1;
	static char[] bridge2;
	static int[][][] cache = new int[3][101][21];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < cache.length; i++)
			for (int j = 0; j < cache[i].length; j++)
				for (int k = 0; k < cache[i][j].length; k++)
					cache[i][j][k] = -1;

		String temp = sc.nextLine();
		carvedStr = new char[temp.length()];
		for (int i = 0; i < temp.length(); i++)
			carvedStr[i] = temp.charAt(i);

		temp = sc.nextLine();
		bridge1 = new char[temp.length()];
		for (int i = 0; i < temp.length(); i++)
			bridge1[i] = temp.charAt(i);

		temp = sc.nextLine();
		bridge2 = new char[temp.length()];
		for (int i = 0; i < temp.length(); i++)
			bridge2[i] = temp.charAt(i);

		bridgeLen = bridge1.length;
		strLen = carvedStr.length;

		// 1번 다리에서 시작하는 경우의 수 + 2번 다리에서 시작하는 경우의 수
		System.out.println(passCount(1, 0, 0) + passCount(2, 0, 0));
	}

	static int passCount(int bridgeId, int startIndex, int strIndex) {
		int result = 0;

		// 기저사례
		if (strIndex == strLen)
			return 1;

		if (cache[bridgeId][startIndex][strIndex] != -1)
			return cache[bridgeId][startIndex][strIndex];

		// 1번 다리에서 시작하면 두루마리 문자열 확인 후 그 이후 index부터 2번 다리에서 찾아줌 
		if (bridgeId == 1) {
			for (int index = startIndex; index < bridgeLen; index++)
				if (bridge1[index] == carvedStr[strIndex])
					result += passCount(2, index + 1, strIndex + 1);
		}

		// 2번 다리에서 시작하면 두루마리 문자열 확인 후 그 이후 index부터 1번 다리에서 찾아줌
		if (bridgeId == 2) {
			for (int index = startIndex; index < bridgeLen; index++)
				if (bridge2[index] == carvedStr[strIndex])
					result += passCount(1, index + 1, strIndex + 1);
		}

		return cache[bridgeId][startIndex][strIndex] = result;
	}
}
