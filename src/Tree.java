import java.io.Serializable;

public class Tree<E> implements Serializable{
	Node<E> root;

	public E search(int k) {
		Node<E> current = root;
		while (current.key != k) {
			if (k < current.key)
				current = current.leftChild;
			else
				current = current.rightChild;
			if (current == null)
				return null;
		}
		return current.data;
	}

	public void insert(int k, E e) {
		Node<E> newNode = new Node<E>(k, e);
		if (root == null)
			root = newNode;
		else {
			Node<E> current = root;
			Node<E> parent;
			while (true) {
				parent = current;
				if (k < current.key) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public boolean delete(int k) {
		Node<E> current = root;
		Node<E> parent = root;
		boolean isLeftChild = true;
		while (current.key != k) { // locate node
			parent = current;
			if (k < current.key) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null)
				return false; // not found
		}
		if (current.leftChild == null && current.rightChild == null) { // if leaf-node
			if (current == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		} else if (current.rightChild == null) // if node has left child only
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else // right child of parent
				parent.rightChild = current.leftChild;
		else if (current.leftChild == null) // if node has right child only
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild) // left child of parent
				parent.leftChild = current.rightChild;
			else // right child of parent
				parent.rightChild = current.rightChild;
		else { // has both children

			Node<E> successor = getSuccessor(current);
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			successor.leftChild = current.leftChild;
		}
		return true;

	}

	private Node<E> getSuccessor(Node<E> delNode) {
		Node<E> successorParent = delNode;
		Node<E> successor = delNode;
		Node<E> current = delNode.rightChild; // go to right child
		while (current != null) { // until no more left children,
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
		}
		// if successor not
		if (successor != delNode.rightChild) { // right child,
			// make connections
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}

	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			preorder(root);
			break;
		case 2:
			inorder(root);
			break;
		case 3:
			postorder(root);
			break;
		}

	}

	public void preorder(Node<E> n) { // Ro L Ri
		if (n == null)
			return;
		else {
			n.display();
			preorder(n.leftChild);
			preorder(n.rightChild);
		}

	}

	public void inorder(Node<E> n) { // L Ro Ri
		if (n == null)
			return;
		else {
			inorder(n.leftChild);
			n.display();
			inorder(n.rightChild);
		}

	}

	public void postorder(Node<E> n) { // L Ri Ro
		if (n == null)
			return;
		else {
			postorder(n.leftChild);
			postorder(n.rightChild);
			n.display();
		}

	}

	public int max() {
		Node<E> current = root;
		while (current.rightChild != null)
			current = current.rightChild;

		// current is right-most node
		return current.key;
	}

	public int min() {
		Node<E> temp = root;
		while (temp.leftChild != null)
			temp = temp.leftChild;

		return temp.key;
	}

	public int depth(int k) {
		Node<E> current = root;
		int depth = 0;
		while (current.key != k) {
			if (k < current.key)
				current = current.leftChild;
			else
				current = current.rightChild;
			depth++;
			if (current == null)
				return -1;
		}
		return depth;
	}

	public void printLeaves() {
		printAllLeaves(root);
	}

	public void printAllLeaves(Node<E> n) {
		if (n != null) {
			if (n.leftChild == null && n.rightChild == null) // no children, LEAF
				n.display();
			else {
				printAllLeaves(n.leftChild);
				printAllLeaves(n.rightChild);
			}
		}
	}

	public int count() {
		return countNodes(root);
	}

	public int countNodes(Node<E> n) {
		if (n == null)
			return 0;
		return 1 + countNodes(n.leftChild) + countNodes(n.rightChild);
	}

	public int countLeaves() {
		return countAllLeaves(root);
	}

	public int countAllLeaves(Node<E> n) {
		if (n == null)
			return 0;
		if (n.leftChild == null && n.rightChild == null) // leaf
			return 1;
		return countAllLeaves(n.leftChild) + countAllLeaves(n.rightChild);
	}

	public int height() {
		return treeHeight(root) - 1;
	}

	public int treeHeight(Node<E> n) {
		if (n == null)
			return 0;
		return 1 + Math.max(treeHeight(n.leftChild), treeHeight(n.rightChild));
	}

	public boolean isFull() {
		return isFullTree(root);
	}

	public boolean isFullTree(Node<E> n) {
		// if n is leaf => return true
		if(n.leftChild == null && n.rightChild == null)
			return true;
		// if n has 2 chld. => call for subtrees
		if(n.leftChild != null && n.rightChild != null)
			return isFullTree(n.leftChild) && isFullTree(n.rightChild);
		// any other case => return false
		return false;
	
	}
	
	public int count(E e) {
		return countElement(root, e);
	}
	
	public int countElement(Node<E> n, E e) {
		if(n==null) return 0;
		if(n.data==e) return 1 +countElement(n.rightChild, e) +countElement(n.leftChild, e) ;
		else return countElement(n.rightChild, e) +countElement(n.leftChild, e) ;
	}
}
