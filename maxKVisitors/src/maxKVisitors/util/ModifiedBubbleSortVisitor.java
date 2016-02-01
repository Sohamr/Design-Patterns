package maxKVisitors.util;

public class ModifiedBubbleSortVisitor implements VisitorI {

	private int k = 0;

	public ModifiedBubbleSortVisitor(int K) {

		this.k = K;

		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass());
	}

	public void visit(ADTI a) {

		int s = k;

		int ex = 0;
		int max;
		for (int i = 0; i < a.getSize() - 1; i++) {
			ex = 0;
			max = a.get(i);
			for (int j = i + 1; j < a.getSize(); j++) {

				if (a.get(j) > max) {

					max = a.get(j);
					a.set(j, a.get(i));
					a.set(i, max);
					ex++;
				}

			}
			s--;
			if (ex == 0 || s <= 0)
				break;

		}

		Logger l = Logger.getInstance();
		if (l.getGlobalDebugValue() == LogType.PRINT_DATA) {
			System.out.println("Bubble sort on " + a.getName());
			a.print(k);
		}
	}

}
