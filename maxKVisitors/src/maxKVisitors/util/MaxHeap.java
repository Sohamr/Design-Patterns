package maxKVisitors.util;

public class MaxHeap {

	private final int SIZE = 10; // initial length of array
	private int next = 0; // limit of elements in array
	private int[] A = new int[SIZE]; // implements tree by storing elements in
										// level order

	// standard resize to avoid overflow

	public void resize() {
		int[] B = new int[A.length * 2];
		for (int i = 0; i < A.length; ++i)
			B[i] = A[i];
		A = B;
	}

	// methods to move up and down tree as array

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public int lchild(int i) {
		return 2 * i + 1;
	}

	public int rchild(int i) {
		return 2 * i + 2;
	}

	public boolean isLeaf(int i) {
		return (lchild(i) >= next);
	}

	public boolean isRoot(int i) {
		return i == 0;
	}

	// standard swap, using indices in array
	public void swap(int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// basic data structure methods

	public boolean isEmpty() {
		return (next == 0);
	}

	public int size() {
		return (next);
	}

	// insert an integer into array at next available location
	// and fix any violations of heap property on path up to root

	public void insert(int k) {
		if (size() == A.length)
			resize();
		A[next] = k;

		int i = next;
		int p = parent(i);
		while (!isRoot(i) && A[i] > A[p]) {
			swap(i, p);
			i = p;
			p = parent(i);
		}

		++next;
	}

	// Remove top (maximum) element, and replace with last element in level
	// order; fix any violations of heap property on a path downwards

	public int getMax() {
		--next;
		swap(0, next); // swap root with last element
		int i = 0; // i is location of new key as it moves down tree

		// while there is a maximum child and element out of order, swap with
		// max child
		int mc = maxChild(i);
		while (!isLeaf(i) && A[i] < A[mc]) {
			swap(i, mc);
			i = mc;
			mc = maxChild(i);
		}

		// / printHeapAsTree();

		return A[next];
	}

	// return index of maximum child of i or -1 if i is a leaf node (no
	// children)
	public int maxChild(int i) {
		if (lchild(i) >= next)
			return -1;
		if (rchild(i) >= next)
			return lchild(i);
		else if (A[lchild(i)] > A[rchild(i)])
			return lchild(i);
		else
			return rchild(i);
	}

	// Apply heapsort to the array A. To use, fill A with keys and then call
	// heapsort

	public void heapSort() {
		next = 0;
		for (int i = 0; i < A.length; ++i)
			// turn A into a heap
			insert(A[i]);
		for (int i = 0; i < A.length; ++i)
			// delete root A.length times, which swaps max into
			getMax(); // right side of the array
	}

	// debug method

	public void printHeap(int k) {

		int s = 0;
		if (k > this.size()) {
			System.out.println("MAX allowed value of k is " + this.size());
			s = this.size();
		} else {
			s = k;

		}

		for (int i = 0; i < s; i++)
			System.out.println(getMax());

	}

	public void printHeapAsTree() {
		printHeapTreeHelper(0, "");
		System.out.println();
	}

	private void printHeapTreeHelper(int i, String indent) {
		if (i < next) {

			printHeapTreeHelper(rchild(i), indent + "   ");
			System.out.println(indent + A[i]);
			printHeapTreeHelper(lchild(i), indent + "   ");
		}
	}
}