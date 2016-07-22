/*
 * https://www.acmicpc.net/problem/2352
 * 탐욕법
 */
import java.util.*;
import java.io.*;

public class Main {

	static class Port {
		int start;
		int end;

		Port(int port1, int port2) {
			if (port1 > port2) {
				int temp = port1;
				port1 = port2;
				port2 = temp;
			}

			this.start = port1;
			this.end = port2;
		}
	}

	static class PortComparator implements Comparator<Port> {
		@Override
		public int compare(Port o1, Port o2) {
			int result = o1.end - o2.end;
			if (o1.end == o2.end)
				result = o1.start - o2.start;
			return result;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Port[] port = new Port[n];

		for (int i = 0; i < n; i++) {
			int port1 = i;
			int port2 = sc.nextInt();
			port[i] = new Port(port1, port2);
		}

		Arrays.sort(port, new PortComparator());

		int ensureStartTime = 0;
		int cnt = 0;
		for (int i = 0; i < port.length; i++) {
			if (ensureStartTime <= port[i].start) {
				ensureStartTime = port[i].end;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
