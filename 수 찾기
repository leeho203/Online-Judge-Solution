/*
 * https://www.acmicpc.net/problem/1920
 * 이진검색트리
 */
import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		private int value;
		private Node left;
		private Node right;

		Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

	static class SearchTree {
		Node root;

		public void addNode(int value) {
			Node node = new Node(value);
			if (root == null)
				root = node;
			else
				addNode(value, root);
		}

		public void addNode(int value, Node root) {
			if (value <= root.getValue()) {
				if (root.getLeft() != null)
					addNode(value, root.getLeft());
				else
					root.setLeft(new Node(value));
			} else {
				if (root.getRight() != null)
					addNode(value, root.getRight());
				else
					root.setRight(new Node(value));
			}
		}

		public boolean contains(int value, Node root) {
			boolean result = false;

			if (root == null)
				return result;

			if (value == root.getValue())
				return true;

			if (value < root.getValue())
				result = contains(value, root.getLeft());
			else if (value > root.getValue())
				result = contains(value, root.getRight());

			return result;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		SearchTree tree = new SearchTree();

		int n = Integer.parseInt(br.readLine());
		String temp1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(temp1, " ");
		while (st1.hasMoreTokens()) {
			tree.addNode(Integer.parseInt(st1.nextToken()));
		}

		int m = Integer.parseInt(br.readLine());
		String temp2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(temp2, " ");
		while (st2.hasMoreTokens()) {
			if (tree.contains(Integer.parseInt(st2.nextToken()), tree.root))
				bw.write(1 + "\n");
			else
				bw.write(0 + "\n");
		}
		bw.flush();
	}
}
