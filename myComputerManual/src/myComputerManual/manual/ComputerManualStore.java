/**
 * 
 */
package myComputerManual.manual;

import java.util.Vector;

import myComputerManual.choice.Choices;
import myComputerManual.component.ComponentFactoryI;
import myComputerManual.component.MyComponent;
import myComputerManual.util.LogType;
import myComputerManual.util.Logger;

/**
 * ComputerManualStore class
 * 
 */
public class ComputerManualStore extends ManualStore {

	private ComponentFactoryI CFI = null;

	/**
	 * Constructor ComputerManualStore
	 */
	public ComputerManualStore() {
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass().getName()
				+ " Class");
	}

	@Override
	protected Manual createManual(Vector<Choices> MMap) {
		CFI = new MyComponent();
		return new ComputerManual(CFI, MMap);

	}

}
