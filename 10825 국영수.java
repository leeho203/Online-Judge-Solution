/*
 * https://www.acmicpc.net/problem/10825
 * 다중정렬
 */
import java.util.*;
import java.io.*;

public class Main {
	static class Student {
		String name;
		int kor;
		int eng;
		int mat;

		Student(String name, int kor, int eng, int mat) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
		}
	}

	static class StudentComparator implements Comparator<Student> {
		@Override
		public int compare(Student stu0, Student stu1) {
			int result = stu1.kor - stu0.kor;

			if (stu0.kor == stu1.kor) {
				result = stu0.eng - stu1.eng;
				if (stu0.eng == stu1.eng) {
					result = stu1.mat - stu0.mat;
					if (stu0.mat == stu1.mat) {
						result = stu0.name.compareTo(stu1.name);
					}
				}
			}

			return result;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Student[] student = new Student[n];

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			String name = temp[0];
			int kor = Integer.parseInt(temp[1]);
			int eng = Integer.parseInt(temp[2]);
			int mat = Integer.parseInt(temp[3]);
			student[i] = new Student(name, kor, eng, mat);
		}

		Arrays.sort(student, new StudentComparator());

		for (Student s : student)
			bw.write(s.name + "\n");

		bw.flush();
	}
}
