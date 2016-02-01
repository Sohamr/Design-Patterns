package maxKVisitors.driver;

import java.io.FileNotFoundException;

import maxKVisitors.util.ADTI;
import maxKVisitors.util.ADTVisitor;
import maxKVisitors.util.Logger;
import maxKVisitors.util.MaxHeap;
import maxKVisitors.util.MaxHeapVisitor;
import maxKVisitors.util.ModifiedBubbleSortVisitor;
import maxKVisitors.util.MyArray;
import maxKVisitors.util.MyVector;
import maxKVisitors.util.VisitorI;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {

		// Check input parameters length 
		if (args.length != 3) {
			System.err.println("Invalid number of arguements");
			System.err.println("<Data Filename> <K> <Debug Value>");
			System.exit(0);
		}
		String fileName = null;
		int k = 0;
		int dval = 0;
		try {
			fileName = args[0];
			k = Integer.parseInt(args[1]);
			dval = Integer.parseInt(args[2]);
			if (k <= 0) {
				System.err.println("Invalid value of k");
				System.exit(1);
			}
			// Initialize logger and set debug value
			Logger l = Logger.getInstance();
			l.setDebugValue(dval);
		} catch (NullPointerException ex) {
			System.exit(1);
		} catch (Exception ex) {
			System.exit(1);
		}
		MyVector vec = new MyVector();
		MyArray arr = new MyArray();

		VisitorI vis1 = new ADTVisitor(fileName);

		vec.accept(vis1);
		arr.accept(vis1);

		MaxHeap heap = new MaxHeap();

		VisitorI vis2 = new MaxHeapVisitor(heap, k);

		vec.accept(vis2);
		arr.accept(vis2);

		ADTI vec1 = new MyVector();
		ADTI arr1 = new MyArray();
		vis1 = new ADTVisitor(fileName);
		vec1.accept(vis1);
		arr1.accept(vis1);

		VisitorI vis3 = new ModifiedBubbleSortVisitor(k);

		vec1.accept(vis3);
		arr1.accept(vis3);

	}

}
