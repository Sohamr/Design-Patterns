package maxKVisitors.util;

import java.util.ArrayList;

public class MyArray implements ADTI {

	private ArrayList<Integer> arr = null;

	/**
	 * Constructor Initialize array
	 */
	public MyArray() {
		arr = new ArrayList<Integer>();
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass());
	}

	@Override
	public void addElement(Integer data) {
		if (null != data) {
			arr.add(data);
			Logger l = Logger.getInstance();
			l.Write(LogType.ADDED_ENTRY, "In " + this.getClass() + "Data "
					+ data);
		}
	}

	@Override
	public void accept(VisitorI vis) {

		vis.visit(this);
	}

	@Override
	public String toString() {
		return (arr != null ? " " + arr : "");
	}

	@Override
	public int getSize() {
		return arr.size();
	}

	public void print(int k) {
		int size = 0;
		if (k > arr.size()) {
			System.out.println("MAX allowed value of k is " + arr.size());
			size = arr.size();

		} else
			size = k;

		for (int i : arr) {
			size--;
			if (size < 0)
				break;
			System.out.println(i);
		}
	}

	@Override
	public int get(int i) {
		return arr.get(i);
	}

	@Override
	public void set(int i, int value) {
		arr.set(i, value);
	}

	@Override
	public String getName() {
		return "MyArray";
	}
}
