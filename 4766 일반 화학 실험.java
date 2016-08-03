/*
 * https://www.acmicpc.net/problem/4766
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> list = new ArrayList<Double>();
		ArrayList<Double> output = new ArrayList<Double>();
		while (true) {
			double temp = sc.nextDouble();
			if (temp == 999)
				break;
			list.add(temp);
		}

		for (int i = 1; i < list.size(); i++)
			output.add(list.get(i) - list.get(i - 1));

		for (int i = 0; i < output.size(); i++)
			System.out.printf("%.2f\n", output.get(i));
	}
}
