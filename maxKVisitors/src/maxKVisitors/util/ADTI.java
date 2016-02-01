package maxKVisitors.util;

public interface ADTI {

	/**
	 * Adds an element
	 * 
	 * @param data
	 *            data to be added
	 */
	public void addElement(Integer data);

	/**
	 * Get item at index i
	 * 
	 * @param i
	 *            index
	 * @return item at index i
	 */
	public int get(int i);

	/**
	 * Set item at index i
	 * 
	 * @param i
	 *            index
	 * @param value
	 *            value to set
	 */
	public void set(int i, int value);

	/**
	 * 
	 * @return Size of ADT
	 */
	public int getSize();

	/**
	 * Print ADT
	 * 
	 * @param k
	 *            Number of elements
	 */
	public void print(int k);

	/**
	 * Accept the visitor
	 * 
	 * @param visitor
	 */
	public void accept(VisitorI visitor);

	String getName();
}
