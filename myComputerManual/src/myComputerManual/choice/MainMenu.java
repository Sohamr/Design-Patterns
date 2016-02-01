package myComputerManual.choice;

public enum MainMenu {

	CPU(0), RAM(1), DISK(2), GRAPHICS_CARD(3), OPTICAL_DRIVE(4), MONITOR(5), OPERATING_SYSTEM(
			6), SYSTEM_SUPPORT(7);

	private int index;

	/**
	 * Set index
	 * 
	 * @param index
	 */
	MainMenu(int index) {
		this.index = index;
	}

	/**
	 * Get index of the passed value
	 * 
	 * @param m
	 * @return index
	 */
	public int getIndex(MainMenu m) {

		return m.index;
	}

}
