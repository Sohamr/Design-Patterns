package maxKVisitors.util;

import maxKVisitors.util.LogType;

public class Logger {

	private static Logger log = null;
	private static LogType globalDebugValue;

	private Logger() {
	}

	/**
	 * Returns the initialized instance
	 * 
	 * @return initialized Logger instance
	 */
	public static Logger getInstance() {

		if (log == null) {
			synchronized (Logger.class) {
				if (log == null)
					log = new Logger();
			}
		}
		return log;
	}

	/**
	 * Sets debug value
	 * 
	 * @param value
	 */
	public void setDebugValue(int value) {

		for (LogType lt : LogType.values()) {
			if (lt.getIndex() == value) {
				globalDebugValue = lt;
				return;
			}
		}

	}

	/**
	 * @return the globalDebugValue
	 */
	public LogType getGlobalDebugValue() {
		return globalDebugValue;
	}

	/**
	 * @param globalDebugValue
	 *            the globalDebugValue to set
	 */
	public void setGlobalDebugValue(LogType globalDebugValue) {
		Logger.globalDebugValue = globalDebugValue;
	}

	/**
	 * Writes to std out
	 * 
	 * @param lt
	 *            Log type
	 * @param s
	 *            String to write
	 */
	public void Write(LogType lt, String s) {
		try {

			if (globalDebugValue == LogType.NO_OUTPUT)
				return;
			else if (lt == globalDebugValue) {
				System.out.println(" " + lt + " " + s.toString());
			}
		} catch (Exception ex) {
			System.err.println("Error Writing to stdout: "
					+ ex.getLocalizedMessage());
			System.exit(1);
		} finally {
		}
	}

	@Override
	public String toString() {
		return "Logger Global value = " + globalDebugValue;
	}

}
