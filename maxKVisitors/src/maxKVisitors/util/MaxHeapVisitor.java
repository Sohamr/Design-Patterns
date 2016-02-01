package maxKVisitors.util;

public class MaxHeapVisitor implements VisitorI {
	MaxHeap m = null;
	int k = 0;

	public MaxHeapVisitor(MaxHeap m, int K) {
		this.m = m;
		this.k = K;
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass());
	}

	public void visit(ADTI a) {
		// TODO Auto-generated method stub
		int size = 0;
		int value = 0;
		size = a.getSize();

		for (int i = 0; i < size; i++) {

			value = a.get(i);
			m.insert(value);

		}
		Logger l = Logger.getInstance();
		if (l.getGlobalDebugValue() == LogType.PRINT_DATA){
		
			System.out.println("Heap sort on " + a.getName());
			m.printHeap(k);
		}
	}

}
