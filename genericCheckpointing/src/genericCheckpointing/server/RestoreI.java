package genericCheckpointing.server;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStrategies.StrategyI;

public interface RestoreI extends StoreRestoreI {

	/**
	 * Read object from file and return created object
	 * 
	 * @param xmlDStrat
	 *            XML Strategy
	 * @return
	 */
	SerializableObject readObj(StrategyI xmlDStrat);

}
