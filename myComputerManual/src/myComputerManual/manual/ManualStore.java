package myComputerManual.manual;

import java.util.Vector;

import myComputerManual.choice.Choices;
import myComputerManual.util.LogType;
import myComputerManual.util.Logger;

/**
 * ManualStore Class
 * 
 */
public abstract class ManualStore {

	/**
	 * Constructor
	 */
	ManualStore() {
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass().getName()
				+ " Class");
	}

	/**
	 * To Create a Manual based on user choices
	 * 
	 * @param MMap
	 *            List of Choices selected
	 * @return object of Manual
	 */
	public final Manual orderManual(Vector<Choices> MMap) {

		Manual m = createManual(MMap);
		m.prepareManual();
		m.createIndex();
		m.createListOfFigures();
		m.createPages();
		m.createGlossary();
		return m;

	}

	/**
	 * Creates Manual
	 * 
	 * @param mMap
	 *            List of Choices selected
	 * @return object of Manual
	 */
	protected abstract Manual createManual(Vector<Choices> mMap);

}