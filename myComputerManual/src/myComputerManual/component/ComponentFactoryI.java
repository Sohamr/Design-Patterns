package myComputerManual.component;

import myComputerManual.choice.Choices;

public interface ComponentFactoryI {

	/**
	 * Creates and returns an object of Component based on choice passed
	 * 
	 * @param c
	 *            Choice of component to create
	 * @return new Component
	 */
	public abstract Component create(Choices c);

	// public abstract Component createCPU(Choices c);
	// public abstract Component createDISK(Choices c);
	// public abstract Component createGrapicCard(Choices c);

}
