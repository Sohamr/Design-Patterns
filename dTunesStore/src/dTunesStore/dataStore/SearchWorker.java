package dTunesStore.dataStore;

import dTunesStore.Interface.IResult;

import dTunesStore.util.LogType;
import dTunesStore.util.Logger;

/**
 *	Class SearchWorker creates N number of threads 
 */
public class SearchWorker implements Runnable {

	private MusicStore ms = null;
	private FileProcessor fp = null;
	private IResult r = null;
	private int threadNo = 0;
	private String s = null;

	/**
	 * 
	 * @param ms MusicStore instance, contains all records, to
	 * 		 search the song, album or singer from the search file
	 * @param fp FileProcessor instance which has the file handle 
	 * 		opened for the search file, to read a line from file  
	 * @param r	Result class 
	 * @param threadNum	Stores the number of threads to be executed
	 */
	public SearchWorker(MusicStore ms, FileProcessor fp, IResult r,
			int threadNum) {
		// PLACEHOLDER
		
		this.ms = ms;
		this.fp = fp;
		this.r = r;
		this.threadNo = threadNum;
		
		Logger.Write(LogType.CONSTRUCTOR,
				"In SearchWorker Class, Thread no. : " + threadNum);
	}
	
	/**
	 * Run method in Runnable interface
	 * All threads execute this method
	 */
	public void run() {
		MusicInfo res = null;
		
		Logger.Write(LogType.THREAD_RUN,
				"In SearchWorker Class Run Method, Thread no. : "
						+ threadNo);
		do {
	
			s = fp.readLineFromFile();

			if (s != null)
				s = s.trim().toUpperCase();
			// System.out.println("In File : "+s);
			if ((res = ms.searchInfo(s)) != null)
				r.storeInfo(res);
		
			// else{
			// if(s != null)
			// System.out.println("Not Found: "+s); }
		
		} while (s != null);

		// System.out.println("Exiting: "+threadNo);

		// PLACEHOLDER

	} // end run(...)

	@Override
	public String toString() {
		return "Search Worker ms = " + ms + ", r = " + r
				+ ", threadNo = " + threadNo + ", s = " + s;
	}

} // end class SearchWorker

