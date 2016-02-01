package studentRecordsBackup.bst;

public interface TreeI {

	/**
	 * Insert Node in Tree
	 * 
	 * @param ins
	 *            Node to insert
	 */
	void insertNode(Node ins);

	/**
	 * Updates Bno of given node
	 * 
	 * @param value
	 *            - Value to increment with
	 */
	public void updateBno(int value);

	/**
	 * Delete node
	 * 
	 * @return deleted node
	 */
	public Object deleteNode();

	/**
	 * Return size - number of nodes of BST
	 */
	public int getSize();

	/**
	 * Returns height of BST
	 */
	public int height();

	/**
	 * Print BST nodes using in order traversal
	 */
	public void printTree();

	/**
	 * Get sum of all nodes in BST
	 * 
	 * @return sum
	 */
	public int getSum();

	/**
	 * Print BST nodes using pre order traversal
	 */
	public void printPreorder();

	/**
	 * Print BST nodes using post order traversal
	 */
	public void printPostorder();

	/**
	 * Insert Node in Tree
	 * 
	 * @param bNo
	 *            - BNumber
	 * @param desc
	 *            - Description
	 */
	void insertNode(int bNo, String desc);

}
