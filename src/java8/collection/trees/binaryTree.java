package java8.collection.trees;

public class binaryTree {
	Node root;

	public void addNode(int index, String name) {
		Node newNode = new Node(index, name);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (index < focusNode.index) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	//Traversal
	//aim for the smallest value first, start at 1st left child, when null is reached then move up in tree
	public void inOrderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}

	//we start off with root, cycle down to our left child, when null is reached,then jump up one parent,to right child, back to main root, then right children
	public void preorderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);
		}
	}

	//left child of root first, then left child of that parent, right child, then bounce one level up,to right child, then next right child, then finally root
	public void postorderTraverseTree(Node focusNode) {
		if (focusNode != null) {
			postorderTraverseTree(focusNode.leftChild);
			postorderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	// Traverse tree
	public void traverseTree(Node node) {
		if (node != null) {
			traverseTree(node.leftChild);
			System.out.print(" " + node.value);
			traverseTree(node.rightChild);
		}
	}

	public Node findNode(int key) {
		// Start at the top of the tree
		Node focusNode = root;
		// While we haven't found the Node
		// keep looking
		while (focusNode.index != key) {
			// If we should search to the left
			if (key < focusNode.index) {
				// Shift the focus Node to the left child
				focusNode = focusNode.leftChild;
			} else {
				// Shift the focus Node to the right child
				focusNode = focusNode.rightChild;
			}
			// The node wasn't found
			if (focusNode == null)
				return null;
		}
		return focusNode;
	}

	public static void main(String[] args) {

		binaryTree tree = new binaryTree();
		tree.addNode(50, "root");
		tree.addNode(40, "mgr");
		tree.addNode(70, "secretary");
		tree.addNode(30, "account");
		tree.addNode(90, "other");
		System.out.println("\nBinary tree");
		tree.traverseTree(tree.root);

		System.out.println("\ninorderTraverseTree");
		tree.inOrderTraverseTree(tree.root);
		System.out.println("\npreorderTraverseTree");
		tree.preorderTraverseTree(tree.root);
		System.out.println("\npostorderTraverseTree");
		tree.postorderTraverseTree(tree.root);
		System.out.println("findNode");
		System.out.println(tree.findNode(70));
	}
}
class Node{
	int index;
	String value;
	Node leftChild;
	Node rightChild;
	public Node(int index, String value) {
		this.index=index;
		this.value=value;
	}
	@Override
	public String toString() {
		return "Node [index=" + value + ",  has a value=" + index + "]";
	}
}