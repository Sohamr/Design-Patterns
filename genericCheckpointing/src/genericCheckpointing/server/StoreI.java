package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.xmlStrategies.StrategyI;

public interface StoreI extends StoreRestoreI {

	/**
	 * Write to XML file
	 * 
	 * @param myFirst
	 *            class
	 * 
	 * @param xmlDStrat
	 *            XML Strategy
	 */
	void writeObj(MyAllTypesFirst myFirst, StrategyI xmlStrat);

	/**
	 * Write to XML file
	 * 
	 * @param myFirst
	 *            class
	 * 
	 * @param xmlDStrat
	 *            XML Strategy
	 */
	void writeObj(MyAllTypesSecond aRecord, StrategyI xmlStrat);
}
