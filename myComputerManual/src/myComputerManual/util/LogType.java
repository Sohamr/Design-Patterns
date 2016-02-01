package myComputerManual.util;

/**
 * To Store Logger Debug value types
 *
 */
public enum LogType {
	NO_OUTPUT(0),PRINT_MANUAL(1),INDEX_ENTRY(2),LIST_FIGURES_ENTRY(3),PAGES_ENTRY(4),GLOSSARY_ENTRY(5),CONSTRUCTOR(6);
	
	private int index = 1;
	LogType(int idx){
		index = idx;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
