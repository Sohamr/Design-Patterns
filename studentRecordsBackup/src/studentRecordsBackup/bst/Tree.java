package studentRecordsBackup.bst;

public class Tree implements TreeI {

	private Node root = null;

	/**
	 * Check if node is null
	 * 
	 * @return - Boolean value
	 */
	public boolean isNull() {
		if (null == root)
			return true;
		return false;
	}

	/**
	 * Insert Node in Tree
	 */
	@Override
	public void insertNode(Node ins) {

		if (0 == ins.getbNo() || null == ins.getDescription())
			throw new NullPointerException();

		root = insertNode(root, ins); // new Node(o);
	}

	/**
	 * Recursive method to insert node in BST
	 * 
	 * @param node
	 *            - Node to insert in
	 * @param ins
	 *            - Node to be inserted
	 * @return - returns node
	 */
	private Node insertNode(Node node, Node ins) {

		if (node == null)
			return ins;
		else if (ins.getbNo() <= node.getbNo())
			node.left = insertNode(node.left, ins);
		else if (ins.getbNo() > (int) node.getbNo())
			node.right = insertNode(node.right, ins);
		return node;

	}

	/**
	 * Insert Node in Tree
	 */
	@Override
	public void insertNode(int bNo, String desc) {
		if (0 == bNo || null == desc)
			throw new NullPointerException();

		root = insertNode(root, bNo, desc); // new Node(o);

	}

	/**
	 * Recursive method to insert node in BST
	 * 
	 * @param node
	 *            node to insert in
	 * @param bNo
	 *            bno to insert
	 * @param desc
	 *            desc to insert
	 * @return inserted node
	 */
	private Node insertNode(Node node, int bNo, String desc) {

		if (node == null)
			return new Node(bNo, desc);
		else if (bNo <= node.getbNo())
			node.left = insertNode(node.left, bNo, desc);
		else if (bNo > (int) node.getbNo())
			node.right = insertNode(node.right, bNo, desc);
		return node;

	}

	/**
	 * Delete node in BST
	 */
	@Override
	public Object deleteNode() {
		return null;
	}

	@Override
	public int getSize() {
		if (isNull())
			return 0;
		return getSize(root);
	}

	private int getSize(Node node) {
		if (null == node)
			return 0;
		else if (node.left == null && node.right == null)
			return 1;
		else
			return getSize(node.left) + getSize(node.right) + 1;
	}

	@Override
	public int height() {
		return height(root);
	}

	private int height(Node p) {
		if (p == null)
			return -1;
		else
			return 1 + Math.max(height(p.left), height(p.right));
	}

	/**
	 * Returns sum of all nodes in BST
	 */
	@Override
	public int getSum() {

		if (isNull())
			return 0;
		return getSum(root);
	}

	/**
	 * Recursive method to calculate sum of all nodes in BST
	 * 
	 * @param node
	 *            - current node
	 * @return sum of current node
	 */
	private int getSum(Node node) {

		if (null == node)
			return 0;

		return node.getbNo() + getSum(node.left) + getSum(node.right);
	}

	/**
	 * Recursive print method
	 * 
	 * @param root2
	 */
	private void printInOrder_r(Node root2) {

		if (null == root2)
			return;

		printInOrder_r(root2.left);
		System.out.println(" " + root2);
		printInOrder_r(root2.right);
	}

	@Override
	public void printTree() {

		if (null == root)
			return;
		printInOrder_r(root);
	}

	/**
	 * Recursive print method
	 * 
	 * @param root2
	 */
	private void printPreOrder_r(Node root2) {

		if (null == root2)
			return;
		System.out.println(" " + root2);
		printPreOrder_r(root2.left);
		printPreOrder_r(root2.right);
	}

	@Override
	public void printPreorder() {

		if (null == root)
			return;
		printPreOrder_r(root);

	}

	/**
	 * Recursive print method
	 * 
	 * @param root2
	 */
	private void printPostOrder_r(Node root2) {

		if (null == root2)
			return;

		printPostOrder_r(root2.left);
		printPostOrder_r(root2.right);
		System.out.println(" " + root2);
	}

	@Override
	public void printPostorder() {

		if (null == root)
			return;
		printPostOrder_r(root);

	}

	public void updateBno(int value) {

		if (0 == value)
			return;
		updateBno(root, value);

	}

	/**
	 * Updates Bno of given node
	 * 
	 * @param node
	 *            - Node to update
	 * @param value
	 *            - Value to increment with
	 */
	private void updateBno(Node node, int value) {

		if (null == node)
			return;
		node.setbNo(node.getbNo() + value);
		updateBno(node.left, value);
		updateBno(node.right, value);
		return;
	}

}
