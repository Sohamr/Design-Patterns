package myComputerManual.component;

import myComputerManual.util.LogType;
import myComputerManual.util.Logger;

public abstract class ComponentAbstractFactory {

	/**
	 * Constructor ComponentAbstractFactory
	 */
	public ComponentAbstractFactory() {
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass().getName()
				+ " Class");
	}
}
