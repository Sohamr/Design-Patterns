package dTunesStore.util;

public class Logger {
	
	/**
	 * 	To store the global value for debugging 
	 */
	private static LogType globalDebugValue ;
	public Logger()  {
		
	}
	
	public static void setDebugValue(int value){
		
		switch(value){
			
			case 0:
					globalDebugValue = LogType.NO_OUTPUT;
					break;
			case 1:
					globalDebugValue = LogType.SEARCH_RESULTS;
					break;				
			case 2:
					globalDebugValue = LogType.RESULT_ENTRY;
					break;				
			case 3:
					globalDebugValue = LogType.THREAD_RUN;
					break;				
			case 4:
					globalDebugValue = LogType.CONSTRUCTOR;
					break;
			}
	}
	
	/**
	 * @return the globalDebugValue
	 */
	public static LogType getGlobalDebugValue() {
		return globalDebugValue;
	}

	/**
	 * @param globalDebugValue the globalDebugValue to set
	 */
	public static void setGlobalDebugValue(LogType globalDebugValue) {
		Logger.globalDebugValue = globalDebugValue;
	}

	public static void Write(LogType lt,String s){
		try {
		   
			if(globalDebugValue == LogType.NO_OUTPUT)
				return;
			else
			if(lt == globalDebugValue){				
				System.out.println(" " + lt + " " + s.toString());
			}
		} catch (Exception ex) {
			System.err.println("Error Writing to stdout: "+ex.getLocalizedMessage());	
			System.exit(1);
		} finally {
		}
	}

	@Override
	public String toString() {
		return "Logger Global value = " + globalDebugValue;
	}

}

