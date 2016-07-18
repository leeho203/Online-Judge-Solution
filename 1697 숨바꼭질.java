import java.util.*;

public class Main {
	static boolean discovered[] = new boolean[100001];
	static int minSecond = 0;

	static class Element {
		int value;
		int cnt;

		Element(int value, int cnt) {
			this.value = value;
			this.cnt = cnt;
		}

		public int getValue() {
			return value;
		}

		public int getCnt() {
			return cnt;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayList<Element> que = new ArrayList<Element>();
		que.add(new Element(n, 0));
		
		// DFS는 무한루프 걸리므로 BFS로 찾아줘야함
		while (!que.isEmpty()) {
			int here = que.get(0).value;
			int time = que.get(0).cnt;
			que.remove(0);

			minSecond = Math.max(minSecond, time);

			if (here == m)
				break;

			if (discovered[here] == false) {
				if (here < 100000)
					que.add(new Element(here + 1, time + 1));
				if (here <= 50000)
					que.add(new Element(here * 2, time + 1));
				if (here > 0)
					que.add(new Element(here - 1, time + 1));
				discovered[here] = true;
			}
		}

		System.out.println(minSecond);
	}
}
