import java.util.*;

public class Main {
	static class Node {
		private char value;
		private Node leftNode;
		private Node rightNode;
        
		Node() {

		}

		Node(char value) {
			this.value = value;
		}

		/* getter */
		public char getValue() {
			return value;
		}

		public Node getLeftNode() {
			return leftNode;
		}

		public Node getRightNode() {
			return rightNode;
		}

		/* setter */
		public void setValue(char value) {
			this.value = value;
		}

		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}

		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
	}

	// 트리는 각 노드를 이진트리형태로 저장하는 형태
	static class Tree {
		private Node rootNode;

                // value값에 해당하는 노드를 만들고 해당 노드의 leftNode, rightNode노드를 설정해서 트리의 노드로 저장해줌
		public void addNode(char value, Node leftNode, Node rightNode) {
                        // rootNode가 없다면 첫 번째 추가노드가 rootNode가 됨
			if (rootNode == null) {
				Node node = new Node();
				node.setValue(value);
				node.setLeftNode(leftNode);
				node.setRightNode(rightNode);
				rootNode = node;
			} else {
				// rootNode부터 시작해서 value값을 가진 Node를 찾는 메서드
				Node node = searchNode(value, rootNode);
				if (node != null) {
					node.setLeftNode(leftNode);
					node.setRightNode(rightNode);
				}
			}

		}

		// 전위순회
		public void preOrder(Node rootNode) {
			if (rootNode == null)
				return;
			char ch = rootNode.getValue();
			if (ch != '.')
				System.out.print(ch);
			preOrder(rootNode.getLeftNode());
			preOrder(rootNode.getRightNode());
		}

		// 중위순회
		public void inOrder(Node rootNode) {
			if (rootNode == null)
				return;
			char ch = rootNode.getValue();
			inOrder(rootNode.getLeftNode());
			if (ch != '.')
				System.out.print(ch);
			inOrder(rootNode.getRightNode());
		}

		// 후위순회
		public void postOrder(Node rootNode) {
			if (rootNode == null)
				return;
			char ch = rootNode.getValue();
			postOrder(rootNode.getLeftNode());
			postOrder(rootNode.getRightNode());
			if (ch != '.')
				System.out.print(ch);
		}

		// value값을 가진 Node를 찾아내서 리턴하는 메서드
		public static Node searchNode(char value, Node node) {
			Node leftResultNode = new Node();
			Node rightResultNode = new Node();
			if (node.getValue() == value)
				return node;
			if (node.getLeftNode() != null)
				leftResultNode = searchNode(value, node.getLeftNode());
			if (node.getRightNode() != null)
				rightResultNode = searchNode(value, node.getRightNode());

			if (leftResultNode == null && rightResultNode != null)
				return rightResultNode;
			else if (leftResultNode != null && rightResultNode == null)
				return leftResultNode;
			else
				return null;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Tree tree = new Tree();
        
                // 노드 입력
		for (int i = 0; i < n; i++) {
			String[] temp = sc.nextLine().split(" ");
			char nodeValue = temp[0].charAt(0);
			char leftNodeValue = temp[1].charAt(0);
			char rightNodeValue = temp[2].charAt(0);
			Node leftNode = new Node(leftNodeValue);
			Node rightNode = new Node(rightNodeValue);
			tree.addNode(nodeValue, leftNode, rightNode);
		}

		tree.preOrder(tree.rootNode);
		System.out.println();
		tree.inOrder(tree.rootNode);
		System.out.println();
		tree.postOrder(tree.rootNode);
		System.out.println();
	}
}
