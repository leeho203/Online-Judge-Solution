/*
 * https://www.acmicpc.net/problem/1946
 * 다중 정렬, 탐욕법
 */
import java.util.*;
import java.io.*;

public class Main {
	static class Applicant {
		int document;
		int interview;

		Applicant(int document, int interview) {
			this.document = document;
			this.interview = interview;
		}
	}

	static class ApplicantComparator implements Comparator<Applicant> {
		@Override
		public int compare(Applicant a0, Applicant a1) {
			int result = a0.document - a1.document;
			if (a0.document == a1.document)
				result = a0.interview - a1.interview;
			return result;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String result = "";

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			Applicant[] app = new Applicant[n];
			for (int j = 0; j < n; j++) {
				int document = sc.nextInt();
				int interview = sc.nextInt();
				app[j] = new Applicant(document, interview);
			}

			Arrays.sort(app, new ApplicantComparator());

			int comp = app[0].interview;
			int cnt = 0;

			for (int j = 0; j < n; j++) {
				if (comp >= app[j].interview) {
					comp = app[j].interview;
					cnt++;
				}
			}
			result += cnt + "\n";
		}

		System.out.print(result);
	}
}
