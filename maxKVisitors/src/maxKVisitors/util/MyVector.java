package maxKVisitors.util;

import java.util.Vector;

public class MyVector implements ADTI {

	private Vector<Integer> vec = null;

	/**
	 * Constructor Initialize vector
	 */
	public MyVector() {
		vec = new Vector<Integer>();
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass());
	}

	@Override
	public void addElement(Integer data) {
		if (null != data) {
			vec.add(data);
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
		return (vec != null ? " " + vec : "");
	}

	@Override
	public int get(int i) {
		return vec.get(i);
	}

	@Override
	public void set(int i, int value) {
		vec.set(i, value);
	}

	@Override
	public int getSize() {
		return vec.size();
	}

	@Override
	public void print(int k) {
		int size = 0;
		if (k > vec.size()) {
			System.out.println("MAX allowed value of k is " + vec.size());
			size = vec.size();
		} else {
			size = k;

		}
		for (int i : vec) {
			size--;
			if (size < 0)
				break;
			System.out.println(i);
		}
	}

	@Override
	public String getName() {
		return "MyVector";
	}

}
