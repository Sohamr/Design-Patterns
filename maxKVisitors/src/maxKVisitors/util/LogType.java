package maxKVisitors.util;

/**
 * To Store Logger Debug value types
 *
 */
public enum LogType {
	NO_OUTPUT(0),PRINT_DATA(1),ADDED_ENTRY(2),CONSTRUCTOR(3);
	
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
